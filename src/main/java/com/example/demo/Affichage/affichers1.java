package com.example.demo.Affichage;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class affichers1 {
    public static void main(String[] args) {
        String fichierCSV = "src\\main\\resources\\FEX\\affichageGlobS1.csv";

        // Lecture du fichier CSV
        List<String[]> donnees = lireFichierCSV(fichierCSV);

        // Génération du fichier XML
        String cheminFichierXML = "src\\main\\resources\\FEX\\affichages1.xml";
        genererxml.genererXML(donnees, cheminFichierXML);

        // Transformation XSLT
        String fichierXSL = "src\\main\\resources\\FEX\\affichageS1.xsl"; //
        String fichierResultatHTML = "src\\main\\resources\\templates\\affichageS1.html";
        transformXSLT.transformerXML(cheminFichierXML, fichierXSL, fichierResultatHTML);
    }

    private static List<String[]> lireFichierCSV(String fichierCSV) {
        List<String[]> lignes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fichierCSV))) {
            // Lecture de toutes les lignes du fichier CSV
            lignes = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return lignes;
    }
}
