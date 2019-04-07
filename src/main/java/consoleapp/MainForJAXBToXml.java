package consoleapp;

import human.Gender;
import human.Human;
import human.Humans;
import org.joda.time.DateTime;
import xml_parsing.JAXBConvertStudentsToXml;

import java.util.ArrayList;

public class MainForJAXBToXml {
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
        System.out.println(JAXBConvertStudentsToXml.convertStudentsToXml(humans));
    }
}
