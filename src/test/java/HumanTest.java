import human.Human;
import human.Sex;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit-тесты через JUnit 5.2 для класса человека {@link Human}
 * @author Кушнеренко Виктор
 * @version 1.2
 */
class HumanTest
{
    /** приватное поле обьекта человека специально для тестов */
    private static Human human;

    /** инициализация данных для тестов */
    @BeforeAll
    static void initTest()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        human = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
    }

    /** очищение обьекта человека после тестирования */
    @AfterAll
    static void afterTest()
    {
        human = null;
    }

    /** тестирование функции получения возраста человека */
    @Test
    void testGetAge()
    {
        int actual = human.getAge();
        int expected = 21;
        assertEquals(expected, actual);
    }

    /** тестирование функции получения ID человека */
    @Test
    void testGetId()
    {
        int actual = human.getId();
        int expected = 0; // значение по умолчанию, которое присваивается человеку после инициализации
        assertEquals(expected, actual);
    }

    /** тестирование функции получения фамилии человека */
    @Test
    void testGetSurname()
    {
        String actual = human.getSurname();
        String expected = "Семенов";
        assertEquals(expected, actual);
    }

    /** тестирование функции получения имени человека */
    @Test
    void testGetName()
    {
        String actual = human.getName();
        String expected = "Семен";
        assertEquals(expected, actual);
    }

    /** тестирование функции получения отчества человека */
    @Test
    void testGetPatronymic()
    {
        String actual = human.getPatronymic();
        String expected = "Семенович";
        assertEquals(expected, actual);
    }

    /** тестирование функции получения даты рождения человека */
    @Test
    void testGetDateOfBirth()
    {
        DateTime actual = human.getDateOfBirth();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime expected = formatter.parseDateTime("14.05.1997");
        assertEquals(expected, actual);
    }

    /** тестирование функции получения ФИО человека */
    @Test
    void testGetFIO()
    {
        String actual = human.getFIO();
        String expected = "Семенов Семен Семенович";
        assertEquals(expected, actual);
    }

    /** тестирование функции получения пола человека */
    @Test
    void testGetSex()
    {
        Sex actual = human.getSex();
        Sex expected = Sex.MALE;
        assertEquals(expected, actual);
    }
}
