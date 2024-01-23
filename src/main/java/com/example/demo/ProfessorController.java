package com.example.demo;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.OutputStream;

@Controller
public class ProfessorController {


    @PostMapping("/generatePdf")
    public void generatePdf(HttpServletResponse response) {
        try {
            System.out.println("i entered succefully");
            // Chemin vers le fichier XML
            File xmlFile = new File("C:\\newt\\demo\\src\\main\\resources\\FEX\\Bulletin.xml");

            // Chemin vers le fichier XSLT
            File xsltFile = new File("C:\\newt\\demo\\src\\main\\resources\\FEX\\pdfnote.xsl");

            // Configuration de FOP
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            response.setContentType("application/pdf");
            OutputStream out = response.getOutputStream();

            // Chargement du XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Transformation XML vers PDF
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            transformer.transform(new StreamSource(xmlFile), new SAXResult(fop.getDefaultHandler()));

            // Fermeture du flux de sortie
            out.close();

            System.out.println("Le fichier PDF a été généré avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("Module")
    public String hajar(Model model) {
        return "yourmodule";
    }

    @PostMapping("/generatePdfliste")
    public void generatePdfliste(HttpServletResponse response) {
        try {
            System.out.println("i entered succefully");
            // Chemin vers le fichier XML
            File xmlFile = new File("C:\\newt\\demo\\src\\main\\resources\\FEX\\Liste.xml");

            // Chemin vers le fichier XSLT
            File xsltFile = new File("C:\\newt\\demo\\src\\main\\resources\\FEX\\pdfliste.xsl");

            // Configuration de FOP
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            response.setContentType("application/pdf");
            OutputStream out = response.getOutputStream();

            // Chargement du XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Transformation XML vers PDF
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            transformer.transform(new StreamSource(xmlFile), new SAXResult(fop.getDefaultHandler()));

            // Fermeture du flux de sortie
            out.close();

            System.out.println("Le fichier PDF a été généré avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }}
}

