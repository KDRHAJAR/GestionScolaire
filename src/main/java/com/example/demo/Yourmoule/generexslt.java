package com.example.demo.Yourmoule;

import com.example.demo.Bulletin.transformXSLT;

public class generexslt {
    public static void main(String[] args) {

        String cheminFichierXML = "src\\main\\resources\\FEX\\Bulletin.xml";


        // Transformation XSLT
        String fichierXSL = "src\\main\\resources\\FEX\\yourmodule.xsl";
        String fichierResultatHTML = "src\\main\\resources\\templates\\yourmodule.html";
        transformXSLT.transformerXML( cheminFichierXML, fichierXSL, fichierResultatHTML);
    }
}
