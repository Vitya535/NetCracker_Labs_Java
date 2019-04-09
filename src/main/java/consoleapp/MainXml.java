package consoleapp;

import human.Gender;
import human.Human;
import org.joda.time.DateTime;
import repository.RepositoryForHumans;
import xml_parsing.ParseableFromXml;
import xml_parsing.ParseableToXml;
import xml_parsing.ParserDOMFromXml;
import xml_parsing.ParserDOMToXml;
import xml_parsing.ParserJAXBFromXml;
import xml_parsing.ParserJAXBToXml;
import xml_parsing.ParserSAXToXml;

import java.util.Scanner;

public class MainXml {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String filename = "src/main/resources/humans.xml";
        RepositoryForHumans repository = new RepositoryForHumans();
        repository.add(new Human("7", "1", "1", new DateTime(1000), Gender.MALE));
        repository.add(new Human("6", "1", "1", new DateTime(1000), Gender.MALE));
        repository.add(new Human("5", "1", "1", new DateTime(1000), Gender.MALE));
        repository.add(new Human("4", "1", "1", new DateTime(1000), Gender.MALE));
        repository.add(new Human("3", "1", "1", new DateTime(1000), Gender.MALE));
        repository.add(new Human("2", "1", "1", new DateTime(1000), Gender.MALE));
        repository.add(new Human("1", "1", "1", new DateTime(1000), Gender.MALE));
        ParseableFromXml parserFromXml;
        ParseableToXml parserToXml;
        RepositoryForHumans newRepository;
        while (true) {
            System.out.println("1. JAXB To Xml");
            System.out.println("2. DOM To Xml");
            System.out.println("3. SAX To Xml");
            System.out.println("4. JAXB From Xml");
            System.out.println("5. DOM From Xml");
            int numberOfCommand = in.nextInt();
            switch (numberOfCommand) {
                case 1:
                    parserToXml = new ParserJAXBToXml();
                    System.out.println(parserToXml.convertStudentsToXml(repository));
                    break;
                case 2:
                    parserToXml = new ParserDOMToXml();
                    System.out.println(parserToXml.convertStudentsToXml(repository));
                    break;
                case 3:
                    parserToXml = new ParserSAXToXml();
                    System.out.println(parserToXml.convertStudentsToXml(repository));
                    break;
                case 4:
                    parserFromXml = new ParserJAXBFromXml();
                    newRepository = parserFromXml.parse(filename);
                    System.out.println(newRepository.toString());
                    break;
                case 5:
                    parserFromXml = new ParserDOMFromXml();
                    newRepository = parserFromXml.parse(filename);
                    System.out.println(newRepository.toString());
                    break;
            }
        }
    }
}
