package com.example.demo.Bulletin;

import java.util.List;

public class generexslt {
    public static void main(String[] args) {

        String cheminFichierXML = "src\\main\\resources\\FEX\\Bulletin.xml";


        // Transformation XSLT
        String fichierXSL = "src\\main\\resources\\FEX\\Bulletin.xsl";
        String fichierResultatHTML = "src\\main\\resources\\templates\\Bulletin.html";
        transformXSLT.transformerXML( cheminFichierXML, fichierXSL, fichierResultatHTML);
    }
}
