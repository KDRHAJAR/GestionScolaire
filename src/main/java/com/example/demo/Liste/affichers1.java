package com.example.demo.Liste;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.Liste.CsvToXmlConverterListe.convertCsvToXml;

public class affichers1 {
    public static void main(String[] args) {
        String fichierCSV = "src\\main\\resources\\FEX\\Liste.csv";



        // Génération du fichier XML
        String cheminFichierXML = "src\\main\\resources\\FEX\\Liste.xml";
        convertCsvToXml(fichierCSV, cheminFichierXML);

        // Transformation XSLT
        String fichierXSL = "src\\main\\resources\\FEX\\Liste.xsl";
        String fichierResultatHTML = "src\\main\\resources\\templates\\Liste.html";
        transformXSLT.transformerXML(cheminFichierXML, fichierXSL, fichierResultatHTML);
    }

    private static List<String[]> lireFichierCSV(String fichierCSV) {
        List<String[]> lignes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fichierCSV))) {
            // Lecture de toutes les lignes du fichier CSV
            lignes = reader.readAll();

            // Convertir les dates au format correct si nécessaire
            for (String[] ligne : lignes) {
                // Vérifier si la ligne a suffisamment d'éléments
                if (ligne.length > 4) {
                    // Remplacez le format de la date par le format souhaité
                    ligne[4] = convertirFormatDate(ligne[4]);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return lignes;
    }

    private static String convertirFormatDate(String date) {
        try {
            // Convertir la date du format "dd/MM/yyyy" à "yyyy-MM-dd"
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = inputFormat.parse(date);
            return outputFormat.format(parsedDate);
        } catch (ParseException e) {
            // Gérer l'exception en cas d'erreur de conversion de date
            e.printStackTrace();
            return date; // Retourner la date d'origine en cas d'échec de la conversion
        }
    }
}
