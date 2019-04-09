package xml_parsing;

import human.Gender;
import human.Human;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMConvertXmlToStudents {

    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.MM.dd");

    public static Human getHuman(Node node) {
        Human human = new Human();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            human.setId(Integer.parseInt(getTagValue("id", element)));
            human.setName(getTagValue("name", element));
            human.setSurname(getTagValue("surname", element));
            human.setPatronymic(getTagValue("patronymic", element));
            human.setDateOfBirth(formatter.parseDateTime(getTagValue("dateOfBirth", element)));

            String genderElement = getTagValue("gender", element);
            if ("MALE".equals(genderElement)) {
                human.setGender(Gender.MALE);
            } else if ("FEMALE".equals(genderElement)) {
                human.setGender(Gender.FEMALE);
            }
        }
        return human;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
