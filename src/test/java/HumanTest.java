import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    static void InitTest()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
    }

    /** очищение обьекта человека после тестирования */
    @AfterAll
    static void AfterTest()
    {
        human = null;
    }

    /** тестирование функции получения возраста человека */
    @Test
    void test_getAge()
    {
        assertEquals(21, human.getAge());
    }

    /** тестирование функции получения ID человека */
    @Test
    void test_getId()
    {
        int i = human.getId();
        System.out.println(i);
    }

    /** тестирование функции получения фамилии человека */
    @Test
    void test_getSurname()
    {
        assertEquals("Семенов", human.getSurname());
    }

    /** тестирование функции получения имени человека */
    @Test
    void test_getName()
    {
        assertEquals("Семен", human.getName());
    }

    /** тестирование функции получения отчества человека */
    @Test
    void test_getPatronymic()
    {
        assertEquals("Семенович", human.getPatronymic());
    }

    /** тестирование функции получения даты рождения человека */
    @Test
    void test_getDate_of_birth()
    {
        System.out.println(human.getDate_of_birth());
    }

    /** тестирование функции получения ФИО человека */
    @Test
    void test_getFIO()
    {
        assertEquals("Семенов Семен Семенович", human.getFIO());
    }

    /** тестирование функции получения пола человека */
    @Test
    void test_getSex()
    {
        assertEquals(Sex.MALE, human.getSex());
    }
}
