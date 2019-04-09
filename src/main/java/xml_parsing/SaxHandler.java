package xml_parsing;

import human.Gender;
import human.Human;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import repository.RepositoryForHumans;

public class SaxHandler extends DefaultHandler {

    public static RepositoryForHumans repository = new RepositoryForHumans(new Human[0]);
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.MM.dd");
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
            repository.add(human);
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
                if ("MALE".equals(genderElement)) {
                    human.setGender(Gender.MALE);
                } else if ("FEMALE".equals(genderElement)) {
                    human.setGender(Gender.FEMALE);
                }
                break;
        }
    }
}
