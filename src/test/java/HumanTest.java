import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest
{
    private static Human human;

    @BeforeAll
    static void InitTest()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
    }

    @AfterAll
    static void AfterTest()
    {
        human = null;
    }

    @Test
    void test_getAge()
    {
        assertEquals(20, human.getAge());
    }

    @Test
    void test_getId()
    {
        int i = human.getId();
        System.out.println(i);
    }

    @Test
    void test_getSurname()
    {
        assertEquals("Кушнеренко", human.getSurname());
    }

    @Test
    void test_getName()
    {
        assertEquals("Виктор", human.getName());
    }

    @Test
    void test_getPatronymic()
    {
        assertEquals("Константинович", human.getPatronymic());
    }

    @Test
    void test_getDate_of_birth()
    {
        System.out.println(human.getDate_of_birth());
    }

    @Test
    void test_getFIO()
    {
        assertEquals("Кушнеренко Виктор Константинович", human.getFIO());
    }

    @Test
    void test_getSex()
    {
        assertEquals(Sex.MALE, human.getSex());
    }
}
