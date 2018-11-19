import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import human.Human;
import human.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;

// ToDo - возможно надо будет поменять структуру тестов (версия у преподвателя была 4.2)
// ToDo - продолжать писать тесты

/**
 * Unit-тесты через JUnit 5.2 для класса человека {@link HumanTest}
 * @author Кушнеренко Виктор
 * @version 1.1
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
        assertEquals(21, human.getAge());
    }

    /** тестирование функции получения ID человека */
    @Test
    void testGetId()
    {
        int i = human.getId();
        System.out.println(i);
    }

    /** тестирование функции получения фамилии человека */
    @Test
    void testGetSurname()
    {
        assertEquals("Семенов", human.getSurname());
    }

    /** тестирование функции получения имени человека */
    @Test
    void testGetName()
    {
        assertEquals("Семен", human.getName());
    }

    /** тестирование функции получения отчества человека */
    @Test
    void testGetPatronymic()
    {
        assertEquals("Семенович", human.getPatronymic());
    }

    /** тестирование функции получения даты рождения человека */
    @Test
    void testGetDateOfBirth()
    {
        System.out.println(human.getDateOfBirth());
    }

    /** тестирование функции получения ФИО человека */
    @Test
    void testGetFIO()
    {
        assertEquals("Семенов Семен Семенович", human.getFIO());
    }

    /** тестирование функции получения пола человека */
    @Test
    void testGetSex()
    {
        assertEquals(Sex.MALE, human.getSex());
    }
}
