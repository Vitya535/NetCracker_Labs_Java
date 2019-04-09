package xml_parsing;

import human.Human;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import repository.RepositoryForHumans;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParserDOMFromXml implements ParseableFromXml {

    @Override
    public RepositoryForHumans parse(String filename) throws Exception {
        File xmlFile = new File(filename);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
        System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
        NodeList nodeList = document.getElementsByTagName("Human");

        Human[] humans = new Human[nodeList.getLength()];
        for (int i = 0; i < nodeList.getLength(); i++) {
            humans[i] = DOMConvertXmlToStudents.getHuman(nodeList.item(i));
        }
        RepositoryForHumans repository = new RepositoryForHumans();
        repository.setArrayOfHumans(humans);
        return repository;
    }
}
