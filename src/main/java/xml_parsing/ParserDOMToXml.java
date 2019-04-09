package xml_parsing;

import human.Human;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import repository.RepositoryForHumans;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;

public class ParserDOMToXml implements ParseableToXml {

    @Override
    public String convertStudentsToXml(RepositoryForHumans repository) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Repository");
        doc.appendChild(rootElement);

        for (Human human : repository.getArrayOfHumans()) {
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

        Writer out = new StringWriter();
        transformer.transform(source, new StreamResult(out));

        return out.toString();
    }
}
