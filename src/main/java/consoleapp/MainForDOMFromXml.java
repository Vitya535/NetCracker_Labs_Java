package consoleapp;

import human.Human;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import xml_parsing.DOMConvertXmlToStudents;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainForDOMFromXml {
    public static void main(String[] args) {
        String filename = "src/main/resources/humans.xml";
        File xmlFile = new File(filename);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("Human");

            List<Human> humans = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                humans.add(DOMConvertXmlToStudents.getHuman(nodeList.item(i)));
            }

            for (Human human : humans) {
                System.out.println(human.toString());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
