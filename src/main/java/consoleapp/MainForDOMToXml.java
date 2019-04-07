package consoleapp;

import human.Gender;
import human.Human;
import human.Humans;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class MainForDOMToXml {

    public static void main(String[] args) {
        Humans humans = new Humans();
        humans.setHumans(new ArrayList<>());
        humans.getHumans().add(new Human("q1", "", "", new DateTime(1000), Gender.MALE));
        humans.getHumans().add(new Human("w1", "", "", new DateTime(1000), Gender.MALE));
        humans.getHumans().add(new Human("aaa bbb", "", "", new DateTime(1000), Gender.MALE));
        humans.getHumans().add(new Human("bbb", "", "", new DateTime(1000), Gender.MALE));
        humans.getHumans().add(new Human("test", "", "", new DateTime(1000), Gender.MALE));
        humans.getHumans().add(new Human("bbb", "", "", new DateTime(1000), Gender.MALE));
        humans.getHumans().add(new Human("r2d2", "", "", new DateTime(1000), Gender.MALE));
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Humans");
            doc.appendChild(rootElement);

            for (Human human : humans.getHumans()) {
                Element elHuman = doc.createElement("Human");
                rootElement.appendChild(elHuman);

                elHuman.setAttribute("id", String.valueOf(human.getId()));
                elHuman.setAttribute("name", human.getName());
                elHuman.setAttribute("surname", human.getSurname());
                elHuman.setAttribute("patronymic", human.getPatronymic());
                elHuman.setAttribute("dateOfBirth", String.valueOf(human.getDateOfBirth()));
                elHuman.setAttribute("gender", String.valueOf(human.getGender()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("file.xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
