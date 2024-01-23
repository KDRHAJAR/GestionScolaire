package com.example.demo.Bulletin;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class affichers1 {
    public static void main(String[] args) {
        String fichierExcel = "src\\main\\resources\\FEX\\Classeur1.xlsx";

        // Lecture du fichier Excel
        List<String[]> donnees = lireFichierExcel(fichierExcel);

        // Génération du fichier XML
        String cheminFichierXML = "src\\main\\resources\\FEX\\Bulletin.xml";
        genererxml.genererXML(donnees, cheminFichierXML);

        // Transformation XSLT
        //String fichierXSL = "src\\main\\resources\\FEX\\Bulletin.xsl";
        //String fichierResultatHTML = "src\\main\\resources\\templates\\affichageS1.html";
        //transformXSLT.transformerXML(cheminFichierXML, fichierXSL, fichierResultatHTML);
    }

    private static List<String[]> lireFichierExcel(String fichierExcel) {
        List<String[]> lignes = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(fichierExcel))) {
            Sheet sheet = workbook.getSheetAt(0); // Assume que les données sont dans la première feuille

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                List<String> rowData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    rowData.add(currentCell.toString());
                }

                lignes.add(rowData.toArray(new String[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lignes;
    }
}
