import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;
import human.Human;
import human.Sex;
import repository.RepositoryForHumans;

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
    private static DateTimeFormatter formatter;

    /** инициализация данных для тестов */
    @BeforeAll
    static void initTest()
    {
        formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
    }

    /** очищение обьекта репозитория после тестирования */
    @AfterAll
    static void afterTest()
    {
        repository = null;
        formatter = null;
    }

    /** инициализация репозитория перед каждым тестом */
    @BeforeEach
    void beforeEachTest() {
        repository = new RepositoryForHumans();
    }

    /** распечатка репозитория после каждого теста */
    @AfterEach
    void afterEachTest() {
        System.out.println(repository);
    }

    /** тестирование функции добавления человека в репозиторий */
    @Test
    void testAdd()
    {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
    }

    /** тестирование функции добавления одного и того же человека */
    @Test
    void testAddSameHumans()
    {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
    }

    /** тестирование функции добавления разных людей */
    @Test
    void testAddDifferentHumans() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
    }


    /** тестирование функции добавления массива из разных людей */
    @Test
    void testAddRangeDifferentHumans()
    {
        DateTime dateOfBirth1 = formatter.parseDateTime("14.05.1997");
        Human newHuman1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth1, Sex.MALE);
        DateTime dateOfBirth2 = formatter.parseDateTime("12.10.1997");
        Human newHuman2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth2, Sex.MALE);
        repository.addRange(new Human[] {newHuman1, newHuman2});
    }

    /** тестирование функции получения информации о человеке по индексу */
    @Test
    void testGet()
    {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        repository.get(0);
    }

    /** тестирование функции получения информации о человеке по несуществующему индексу */
    @Test
    void testGetNotExistingHuman() throws ArrayIndexOutOfBoundsException
    {
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
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        repository.removeAt(0);
    }

    /** тестирование функции удаления несуществующего человека из репозитория */
    @Test
    void testRemoveAtNotExistingHuman() throws ArrayIndexOutOfBoundsException
    {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeAt(4));
        assertNotNull(thrown.getMessage());
    }
}
