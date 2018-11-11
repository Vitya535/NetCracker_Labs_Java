import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RepositoryTest
{
    private static Repository_For_Humans repository;

    @BeforeAll
    static void InitTest()
    {
        repository = new Repository_For_Humans();
    }

    @AfterAll
    static void AfterTest()
    {
        repository = null;
    }


    @Test
    void test_Add()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        Human new_human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        System.out.println(repository);
    }

    @RepeatedTest(2)
    void test_Add_two_times()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        Human new_human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        System.out.println(repository);
    }

    @Test
    void test_AddRange()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth_1 = formatter.parseDateTime("12.03.1998");
        Human new_human_1 = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth_1, Sex.MALE);
        DateTime date_of_birth_2 = formatter.parseDateTime("12.10.1997");
        Human new_human_2 = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth_2, Sex.MALE);
        repository.AddRange(new Human[] {new_human_1, new_human_2});
        System.out.println(repository);
    }

    @Test
    void test_Get()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        Human new_human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        repository.Get(0);
    }

    @Test
    void test_Get_not_existing_human() throws ArrayIndexOutOfBoundsException
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        Human new_human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.Get(4));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void test_RemoveAt()
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        Human new_human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        repository.RemoveAt(0);
    }

    @Test
    void test_RemoveAt_not_existing_human() throws ArrayIndexOutOfBoundsException
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime date_of_birth = formatter.parseDateTime("12.03.1998");
        Human new_human = new Human("Кушнеренко", "Виктор", "Константинович", date_of_birth, Sex.MALE);
        repository.Add(new_human);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.RemoveAt(4));
        assertNotNull(thrown.getMessage());
    }
}
