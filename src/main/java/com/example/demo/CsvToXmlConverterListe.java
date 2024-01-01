package com.example.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class CsvToXmlConverterListe {

    public static void convertCsvToXml(String csvFilePath, String xmlFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element studentsElement = document.createElement("students");
            document.appendChild(studentsElement);

            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] columns = line.split(";");

                // Check if the line has the expected number of columns
                if (columns.length >= 5) {
                    Element studentElement = document.createElement("student");
                    studentsElement.appendChild(studentElement);

                  addXmlElement(document, studentElement, "numero", columns[0]);
                  addXmlElement(document, studentElement, "nom", columns[1]);
                  addXmlElement(document, studentElement, "prenom", columns[2]);
                  addXmlElement(document, studentElement, "filiere", columns[3]);
                  addXmlElement(document, studentElement, "date_inscription", columns[4]);
                } else {
                    System.err.println("Skipping invalid line: " + line);
                }
            }

            // Add indentation and line breaks for better readability
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new FileOutputStream(new File(xmlFilePath)));

            transformer.transform(domSource, streamResult);

            System.out.println("Conversion terminée avec succès!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addXmlElement(Document document, Element parentElement, String tagName, String textContent) {
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(textContent));
        parentElement.appendChild(element);
    }

    public static void main(String[] args) {
        String csvFilePath = "src\\main\\resources\\FEX\\listeEtudiantsGINFO_ENSATa.csv";
        String xmlFilePath = "src/main/resources/FEX/fichier.xml";
        convertCsvToXml(csvFilePath, xmlFilePath);
    }
}
