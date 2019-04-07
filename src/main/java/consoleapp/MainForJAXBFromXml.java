package consoleapp;

import human.Human;
import human.Humans;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainForJAXBFromXml {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Humans.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();

        Humans humans = (Humans) unmarshaller.unmarshal(new File("src/main/resources/humans.xml"));

        for (Human human : humans.getHumans()) {
            System.out.println(human);
        }
    }
}
