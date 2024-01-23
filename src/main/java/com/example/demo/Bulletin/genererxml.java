package com.example.demo.Bulletin;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

public class genererxml {
    public static void genererXML(List<String[]> donnees, String cheminFichierXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element racine = document.createElement("bulletin");
            document.appendChild(racine);

            int nombreMatieres = donnees.get(0).length - 2; // En supposant que les deux premières colonnes sont 'Nom' et 'Prénom'

            for (String[] ligne : donnees) {
                if (ligne.length >= 10) {
                    Element etudiant = document.createElement("etudiant");
                    racine.appendChild(etudiant);

                    String[] balises = { "Nom", "Prénom", "xml", "java",  "administration", "optimisation","Add_System", "progsystem", "uml", "IHM" };

                    for (int i = 0; i < 10; i++) {
                        // Modify how the element names are generated
                        String elementName =   balises[i]; // Use a prefix and make it lowercase
                        Element element = document.createElement(elementName);
                        element.appendChild(document.createTextNode(ligne[i]));
                        etudiant.appendChild(element);
                    }

                    // Calcul de la moyenne et ajout de la balise "MOYENNE"
                    double moyenne = calculerMoyenne(ligne, 2); // Use the current student's data for calculating the average

                    Element moyenneElement = document.createElement("MOYENNE");
                    moyenneElement.appendChild(document.createTextNode(String.valueOf(moyenne)));
                    etudiant.appendChild(moyenneElement);
                } else {
                    System.out.println("Données invalides dans la ligne : " + String.join(", ", ligne));
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult resultat = new StreamResult(cheminFichierXML);

            transformer.transform(source, resultat);

            System.out.println("Fichier XML généré avec succès.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static double calculerMoyenne(String[] ligne, int indexColonne) {
        double somme = 0;
        int nombreElements = 0;

        if (ligne.length > indexColonne) {
            try {
                somme += Double.parseDouble(ligne[indexColonne]);
                nombreElements++;
            } catch (NumberFormatException e) {
                System.out.println("La valeur dans la colonne 'optimisation' n'est pas un nombre : " + ligne[indexColonne]);
            }
        }

        if (nombreElements > 0) {
            return somme / nombreElements;
        } else {
            return 0; // or a default value if you prefer
        }
    }



}
