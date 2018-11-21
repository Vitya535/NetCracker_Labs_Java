import comparers.HumanAgeComparator;
import comparers.HumanDateOfBirthComparator;
import comparers.HumanSurnameComparator;
import human.Human;
import human.Sex;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;
import repository.RepositoryForHumans;
import sorters.BubbleSorter;
import sorters.InsertSorter;
import sorters.ShellSorter;
import sorters.Sorter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit-тесты через JUnit 5.2 для репозитория с людьми {@link RepositoryForHumans}
 * @author Кушнеренко Виктор
 * @version 1.2
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
        repository = null;
    }

    /** тестирование функции Count при добавлении одинаковых людей */
    @Test
    void testCountWithSameHumans() {
        int expected = 1;
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        int actual = repository.Count();
        assertEquals(expected, actual);
    }

    /** тестирование функции Count при добавлении разных людей */
    @Test
    void testCountWithDifferentHumans() {
        int expected = 3;
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        int actual = repository.Count();
        assertEquals(expected, actual);
    }

    /** тестирование функции получения сортировщика */
    @Test
    void testGetSorter() {
        Sorter expected = new ShellSorter();
        Sorter actual = repository.getSorter();
        System.out.println(expected);
        System.out.println(actual);
    }

    /** тестирование функции задания сортировщика */
    @Test
    void testSetSorter() {
        Sorter expected = new BubbleSorter();
        repository.setSorter(new BubbleSorter());
        Sorter actual = repository.getSorter();
        System.out.println(expected);
        System.out.println(actual);
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

    /** тестирование функции добавления массива из одинаковых людей */
    @Test
    void testAddRangeSimilarHumans()
    {
        DateTime dateOfBirth1 = formatter.parseDateTime("14.05.1997");
        Human newHuman1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth1, Sex.MALE);
        DateTime dateOfBirth2 = formatter.parseDateTime("14.05.1997");
        Human newHuman2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth2, Sex.MALE);
        repository.addRange(new Human[] {newHuman1, newHuman2});
    }

    /** тестирование функции удаления конкретного человека */
    @Test
    void testRemove() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.remove(new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE));
    }

    /** тестирование функции удаления конкретного несуществующего человека */
    @Test
    void testRemoveNotExistingHuman() throws Exception {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        Human newHuman_4 = new Human("Пупкин", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        Throwable thrown = Assertions.assertThrows(Exception.class, () -> repository.remove(newHuman_4));
        assertNotNull(thrown.getMessage());
    }

    /** тестирование функции удаления человека из репозитория */
    @Test
    void testRemoveAt()
    {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.removeAt(0);
    }

    /** тестирование функции удаления несуществующего человека из репозитория */
    @Test
    void testRemoveAtNotExistingHuman() throws ArrayIndexOutOfBoundsException
    {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeAt(4));
        assertNotNull(thrown.getMessage());
    }

    /** тестирование функции получения информации о человеке по индексу */
    @Test
    void testGet()
    {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        repository.get(0);
    }

    /** тестирование функции получения информации о человеке по несуществующему индексу */
    @Test
    void testGetNotExistingHuman() throws ArrayIndexOutOfBoundsException
    {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.get(4));
        assertNotNull(thrown.getMessage());
    }

    /** тестирование задания нового человека на существующую позицию */
    @Test
    void testSet() {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.set(0, newHuman_3);
    }

    /** тестирование задания нового человека на несуществующую позицию */
    @Test
    void testSetNotExistingHuman() throws Exception {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Sex.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        Throwable thrown = Assertions.assertThrows(Exception.class, () -> repository.set(4, newHuman_3));
        assertNotNull(thrown.getMessage());
    }

    /** тестирование поиска по фамилии в репозитории */
    @Test
    void testFindOnSurname() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1997");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        RepositoryForHumans find_rep = repository.findOn("Пупкин");
        System.out.println(find_rep);
    }

    /** тестирование поиска по дате рождения в репозитории */
    @Test
    void testFindOnDateOfBirth() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(formatter.parseDateTime("14.05.1996"));
        System.out.println(find_rep);
  }

    /** тестирование поиска по возрасту в репозитории */
    @Test
    void testFindOnAge() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(22);
        System.out.println(find_rep);
    }

    /** тестирование поиска по несуществующей фамилии в репозитории */
    @Test
    void testFindOnSurnameNothing() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn("Пупкина");
        System.out.println(find_rep);
    }

    /** тестирование поиска по несуществующей дате рождения в репозитории */
    @Test
    void testFindOnDateOfBirthNothing() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(formatter.parseDateTime("14.05.1997"));
        System.out.println(find_rep);
    }

    /** тестирование поиска по несуществующему возрасту в репозитории */
    @Test
    void testFindOnAgeNothing() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(30);
        System.out.println(find_rep);
    }

    /** тестирование сортировки пузырьком по фамилии для репозитория */
    @Test
    void testBubbleSortSurname() {
        repository.setSorter(new BubbleSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanSurnameComparator());
    }

    /** тестирование сортировки вставками по фамилии для репозитория */
    @Test
    void testInsertSortSurname() {
        repository.setSorter(new InsertSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanSurnameComparator());
    }

    /** тестирование сортировки Шелла по фамилии для репозитория */
    @Test
    void testShellSortSurname() {
        repository.setSorter(new ShellSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanSurnameComparator());
    }

    /** тестирование сортировки пузырьком по дате рождения для репозитория */
    @Test
    void testBubbleSortDateOfBirth() {
        repository.setSorter(new BubbleSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanDateOfBirthComparator());
    }

    /** тестирование сортировки вставками по дате рождения для репозитория */
    @Test
    void testInsertSortDateOfBirth() {
        repository.setSorter(new InsertSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanDateOfBirthComparator());
    }

    /** тестирование сортировки Шелла по дате рождения для репозитория */
    @Test
    void testShellSortDateOfBirth() {
        repository.setSorter(new ShellSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanDateOfBirthComparator());
    }

    /** тестирование сортировки пузырьком по возрасту для репозитория */
    @Test
    void testBubbleSortAge() {
        repository.setSorter(new BubbleSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanAgeComparator());
    }

    /** тестирование сортировки вставками по возрасту для репозитория */
    @Test
    void testInsertSortAge() {
        repository.setSorter(new InsertSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanAgeComparator());
    }

    /** тестирование сортировки Шелла по возрасту для репозитория */
    @Test
    void testShellSortAge() {
        repository.setSorter(new ShellSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Sex.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Sex.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Sex.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Sex.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanAgeComparator());
    }
}
