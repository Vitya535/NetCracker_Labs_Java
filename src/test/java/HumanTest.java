import human.Gender;
import human.Human;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit-tests wrote on JUnit 5.2 for human class {@link Human}
 *
 * @author Kushnerenko Victor
 */
class HumanTest {
    /**
     * private field of human object special for tests
     */
    private static Human human;

    /**
     * initialize data for tests
     */
    @BeforeAll
    static void initTest() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        human = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
    }

    /**
     * clear human object after all tests
     */
    @AfterAll
    static void afterTest() {
        human = null;
    }

    /**
     * test for function, which getting age of human
     */
    @Test
    void testGetAge() {
        int actual = human.getAge();
        int expected = 21;
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting id of human
     */
    @Test
    void testGetId() {
        int actual = human.getId();
        int expected = 0; // значение по умолчанию, которое присваивается человеку после инициализации
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting surname of human
     */
    @Test
    void testGetSurname() {
        String actual = human.getSurname();
        String expected = "Семенов";
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting name of human
     */
    @Test
    void testGetName() {
        String actual = human.getName();
        String expected = "Семен";
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting patronymic of human
     */
    @Test
    void testGetPatronymic() {
        String actual = human.getPatronymic();
        String expected = "Семенович";
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting date of birth of human
     */
    @Test
    void testGetDateOfBirth() {
        DateTime actual = human.getDateOfBirth();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime expected = formatter.parseDateTime("14.05.1997");
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting full name of human
     */
    @Test
    void testGetFIO() {
        String actual = human.getFIO();
        String expected = "Семенов Семен Семенович";
        assertEquals(expected, actual);
    }

    /**
     * test for function, which getting gender of human
     */
    @Test
    void testGetSex() {
        Gender actual = human.getGender();
        Gender expected = Gender.MALE;
        assertEquals(expected, actual);
    }
}
