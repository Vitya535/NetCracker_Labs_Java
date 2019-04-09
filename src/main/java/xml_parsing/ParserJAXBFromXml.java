package xml_parsing;

import repository.RepositoryForHumans;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParserJAXBFromXml implements ParseableFromXml {
    @Override
    public RepositoryForHumans parse(String filename) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(RepositoryForHumans.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();

        return (RepositoryForHumans) unmarshaller.unmarshal(new File(filename));
    }
}
