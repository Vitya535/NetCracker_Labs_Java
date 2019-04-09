package xml_parsing;

import repository.RepositoryForHumans;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ParserJAXBToXml implements ParseableToXml {

    @Override
    public String convertStudentsToXml(RepositoryForHumans repository) {
        StringWriter writer = new StringWriter();
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(RepositoryForHumans.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(repository, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
