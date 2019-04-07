package consoleapp;

import human.Human;
import org.xml.sax.SAXException;
import xml_parsing.SaxHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MainForSAXToXml {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SaxHandler handler = new SaxHandler();
        parser.parse(new File("src/main/resources/humans.xml"), handler);

        for (Human human : SaxHandler.humans) {
            System.out.println(human);
        }
    }
}
