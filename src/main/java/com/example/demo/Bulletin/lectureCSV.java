package com.example.demo.Bulletin;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class lectureCSV {
    public static void main(String[] args) {
        String fichierExcel = "C:\\newt\\demo\\src\\main\\resources\\FEX\\Classeur1.xlsx";

        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(fichierExcel))) {
            Sheet sheet = workbook.getSheetAt(0); // Assume que les données sont dans la première feuille

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    System.out.print(currentCell + " ");
                }
                System.out.println(); // Nouvelle ligne pour chaque nouvelle rangée
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
