import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit-тесты через JUnit 5.2 для репозитория с людьми {@link RepositoryTest}
 * @author Кушнеренко Виктор
 * @version 1.1
 */
class RepositoryTest
{
    /** приватное поле обьекта репозитория специально для тестов */
    private static Repository_For_Humans repository;

    /** инициализация данных для тестов */
    @BeforeAll
    static void InitTest()
    {
        repository = new Repository_For_Humans();
    }

    /** очищение обьекта репозитория после тестирования */
    @AfterAll
    static void AfterTest()
    {
        repository = null;
    }

    /** тестирование функции добавления человека в репозиторий */
    @Test
    void test_Add()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        Human new_human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        System.out.println(repository);
    }

    /** тестирование функции добавления одного и того же человека */
    @RepeatedTest(2)
    void test_Add_two_times()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        Human new_human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        System.out.println(repository);
    }

    /** тестирование функции добавления массива из людей */
    @Test
    void test_AddRange()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth_1 = formatter.parseDateTime("14.05.1997");
        Human new_human_1 = new Human("Семенов", "Семен", "Семенович", date_of_birth_1, Sex.MALE);
        DateTime date_of_birth_2 = formatter.parseDateTime("12.10.1997");
        Human new_human_2 = new Human("Семенов", "Семен", "Семенович", date_of_birth_2, Sex.MALE);
        repository.AddRange(new Human[] {new_human_1, new_human_2});
        System.out.println(repository);
    }

    /** тестирование функции получения информации о человеке по индексу */
    @Test
    void test_Get()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        Human new_human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        repository.Get(0);
    }

    /** тестирование функции получения информации о человеке по несуществующему индексу */
    @Test
    void test_Get_not_existing_human() throws ArrayIndexOutOfBoundsException
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        Human new_human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.Get(4));
        assertNotNull(thrown.getMessage());
    }

    /** тестирование функции удаления человека из репозитория */
    @Test
    void test_RemoveAt()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        Human new_human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        repository.RemoveAt(0);
    }

    /** тестирование функции удаления несуществующего человека из репозитория */
    @Test
    void test_RemoveAt_not_existing_human() throws ArrayIndexOutOfBoundsException
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("14.05.1997");
        Human new_human = new Human("Семенов", "Семен", "Семенович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.RemoveAt(4));
        assertNotNull(thrown.getMessage());
    }
}
