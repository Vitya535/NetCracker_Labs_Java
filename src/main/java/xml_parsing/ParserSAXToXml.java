package xml_parsing;

import repository.RepositoryForHumans;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Arrays;

public class ParserSAXToXml implements ParseableToXml {

    @Override
    public String convertStudentsToXml(RepositoryForHumans repository) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        SaxHandler handler = new SaxHandler();
        parser.parse(new File("src/main/resources/humans.xml"), handler);

        return Arrays.toString(SaxHandler.repository.getArrayOfHumans());
    }
}
