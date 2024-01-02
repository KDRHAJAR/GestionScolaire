package com.example.demo.Liste;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class transformXSLT {
    public static void transformerXML(String xmlPath, String xslPath, String outputPath) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File(xslPath)));

            transformer.transform(new StreamSource(new File(xmlPath)), new StreamResult(new File(outputPath)));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
