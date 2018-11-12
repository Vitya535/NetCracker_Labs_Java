import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// ToDo - возможно надо будет поменять структуру тестов (версия у преподавателя 4.2)
// ToDo - продолжать писать тесты

/**
 * Unit-тесты через JUnit 5.2 для репозитория с людьми {@link RepositoryTest}
 * @author Кушнеренко Виктор
 * @version 1.1
 */
class RepositoryTest
{
    /** приватное поле обьекта репозитория специально для тестов */
    private static RepositoryForHumans repository;

    /** инициализация данных для тестов */
    @BeforeAll
    static void initTest()
    {
        repository = new RepositoryForHumans();
    }

    /** очищение обьекта репозитория после тестирования */
    @AfterAll
    static void afterTest()
    {
        repository = null;
    }

    /** тестирование функции добавления человека в репозиторий */
    @Test
    void testAdd()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
    }

    /** тестирование функции добавления одного и того же человека */
    @RepeatedTest(2)
    void testAddTwoTimes()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
    }

    /** тестирование функции добавления массива из людей */
    @Test
    void testAddRange()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth1 = formatter.parseDateTime("14.05.1997");
        Human newHuman1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth1, Sex.MALE);
        DateTime dateOfBirth2 = formatter.parseDateTime("12.10.1997");
        Human newHuman2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth2, Sex.MALE);
        repository.addRange(new Human[] {newHuman1, newHuman2});
        System.out.println(repository);
    }

    /** тестирование функции получения информации о человеке по индексу */
    @Test
    void testGet()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        repository.get(0);
    }

    /** тестирование функции получения информации о человеке по несуществующему индексу */
    @Test
    void testGetNotExistingHuman() throws ArrayIndexOutOfBoundsException
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.get(4));
        assertNotNull(thrown.getMessage());
    }

    /** тестирование функции удаления человека из репозитория */
    @Test
    void testRemoveAt()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        repository.removeAt(0);
    }

    /** тестирование функции удаления несуществующего человека из репозитория */
    @Test
    void testRemoveAtNotExistingHuman() throws ArrayIndexOutOfBoundsException
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeAt(4));
        assertNotNull(thrown.getMessage());
    }
}
