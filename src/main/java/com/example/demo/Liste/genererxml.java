package com.example.demo.Liste;

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

            Element racine = document.createElement("etudiants");
            document.appendChild(racine);

            for (int lineNumber = 1; lineNumber < donnees.size(); lineNumber++) {
                String[] ligne = donnees.get(lineNumber);

                // Check if the array has enough elements before accessing them
                if (ligne.length >= 5) {
                    Element etudiant = document.createElement("etudiant");
                    racine.appendChild(etudiant);

                    String[] balises = {"Numero", "Nom", "Prenom", "Filiere", "Date_Inscreption"};
                    for (int i = 0; i < balises.length; i++) {
                        // Check if the current index is within the bounds of the array
                        if (i < ligne.length) {
                            Element element = document.createElement(balises[i]);
                            element.appendChild(document.createTextNode(ligne[i]));
                            etudiant.appendChild(element);
                        } else {
                            System.out.println("Invalid data in line " + lineNumber + ": " + String.join(", ", ligne));
                            // You may choose to skip this line or take other appropriate action
                            break;  // Stop processing the current line
                        }
                    }
                } else {
                    System.out.println("Invalid data in line " + lineNumber + ": " + String.join(", ", ligne));
                    // You may choose to skip this line or take other appropriate action
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");  // Ajout de cette ligne pour l'indentation
            DOMSource source = new DOMSource(document);
            StreamResult resultat = new StreamResult(cheminFichierXML);

            transformer.transform(source, resultat);

            System.out.println("Fichier XML généré avec succès.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
    }




