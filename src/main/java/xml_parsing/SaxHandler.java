package xml_parsing;

import human.Gender;
import human.Human;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {

    public static List<Human> humans = new ArrayList<>();
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
    private Human human = new Human();
    private String thisElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        thisElement = qName;
        if ("Human".equals(qName)) {
            human = new Human();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        thisElement = "";
        if ("Human".equals(qName)) {
            humans.add(human);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        switch (thisElement) {
            case "id":
                human.setId(Integer.valueOf(new String(ch, start, length)));
                break;
            case "name":
                human.setName(new String(ch, start, length));
                break;
            case "surname":
                human.setSurname(new String(ch, start, length));
                break;
            case "patronymic":
                human.setPatronymic(new String(ch, start, length));
                break;
            case "dateOfBirth":
                human.setDateOfBirth(formatter.parseDateTime(new String(ch, start, length)));
                break;
            case "gender":
                String genderElement = new String(ch, start, length);
                if ("Мужской".equals(genderElement)) {
                    human.setGender(Gender.MALE);
                } else if ("Женский".equals(genderElement)) {
                    human.setGender(Gender.FEMALE);
                }
                break;
        }
    }
}
