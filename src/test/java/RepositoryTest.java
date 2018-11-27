import comparers.HumanAgeComparator;
import comparers.HumanDateOfBirthComparator;
import comparers.HumanSurnameComparator;
import human.Gender;
import human.Human;
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
 * Unit-tests on JUnit 5.2 for repository with humans {@link RepositoryForHumans}
 * @author Kushnerenko Victor
 * @version 1.2
 */
class RepositoryTest {

    /** private field for object of repository special for tests */
    private static RepositoryForHumans repository;

    /** private field for object of datetimeformatter special for tests */
    private static DateTimeFormatter formatter;

    /** initializing data for tests */
    @BeforeAll
    static void initTest() {
        formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
    }

    /** clear objects after all tests */
    @AfterAll
    static void afterTest() {
        repository = null;
        formatter = null;
    }

    /** initializing repository before each test */
    @BeforeEach
    void beforeEachTest() {
        repository = new RepositoryForHumans();
    }

    /** printing repository after each test */
    @AfterEach
    void afterEachTest() {
        System.out.println(repository);
        repository = null;
    }

    /** testing count function at addition similar people */
    @Test
    void testCountWithSameHumans() {
        int expected = 1;
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        int actual = repository.count();
        assertEquals(expected, actual);
    }

    /** testing count function at addition different people */
    @Test
    void testCountWithDifferentHumans() {
        int expected = 3;
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        int actual = repository.count();
        assertEquals(expected, actual);
    }

    /** testing function getting sorter */
    @Test
    void testGetSorter() {
        Sorter expected = new ShellSorter();
        Sorter actual = repository.getSorter();
        System.out.println(expected);
        System.out.println(actual);
    }

    /** testing function setting sorter */
    @Test
    void testSetSorter() {
        Sorter expected = new BubbleSorter();
        repository.setSorter(new BubbleSorter());
        Sorter actual = repository.getSorter();
        System.out.println(expected);
        System.out.println(actual);
    }

    /** testing function - add human to repository */
    @Test
    void testAdd() {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
        repository.add(newHuman);
    }

    /** testing function - add similar humans to repository */
    @Test
    void testAddSameHumans() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
    }

    /** testing function - add different humans to repository */
    @Test
    void testAddDifferentHumans() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
    }


    /** testing function - add array of different humans to repository */
    @Test
    void testAddRangeDifferentHumans() {
        DateTime dateOfBirth1 = formatter.parseDateTime("14.05.1997");
        Human newHuman1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth1, Gender.MALE);
        DateTime dateOfBirth2 = formatter.parseDateTime("12.10.1997");
        Human newHuman2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth2, Gender.MALE);
        repository.addRange(new Human[]{newHuman1, newHuman2});
    }

    /** testing function - add array of similar humans to repository */
    @Test
    void testAddRangeSimilarHumans() {
        DateTime dateOfBirth1 = formatter.parseDateTime("14.05.1997");
        Human newHuman1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth1, Gender.MALE);
        DateTime dateOfBirth2 = formatter.parseDateTime("14.05.1997");
        Human newHuman2 = new Human("Семенов", "Семен", "Семенович", dateOfBirth2, Gender.MALE);
        repository.addRange(new Human[]{newHuman1, newHuman2});
    }

    /** testing function - remove concrete human */
    @Test
    void testRemove() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.remove(new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE));
    }

    /** testing function - remove concrete not existing human */
    @Test
    void testRemoveNotExistingHuman() throws Exception {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        Human newHuman_4 = new Human("Пупкин", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        Throwable thrown = Assertions.assertThrows(Exception.class, () -> repository.remove(newHuman_4));
        assertNotNull(thrown.getMessage());
    }

    /** testing function - remove concrete human on index */
    @Test
    void testRemoveAt() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.removeAt(0);
    }

    /** testing function - remove concrete not existing human on index */
    @Test
    void testRemoveAtNotExistingHuman() throws ArrayIndexOutOfBoundsException {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> repository.removeAt(4));
        assertNotNull(thrown.getMessage());
    }

    /** testing function - get information about human on index */
    @Test
    void testGet() {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        repository.get(0);
    }

    /** testing function - get information about not existing human on index */
    @Test
    void testGetNotExistingHuman() throws ArrayIndexOutOfBoundsException {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        Throwable thrown = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.get(4));
        assertNotNull(thrown.getMessage());
    }

    /** testing function - set new human on existing position */
    @Test
    void testSet() {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.set(0, newHuman_3);
    }

    /** testing function - set new human on not existing position */
    @Test
    void testSetNotExistingHuman() throws Exception {
        DateTime dateOfBirth = formatter.parseDateTime("14.05.1997");
        Human newHuman = new Human("Семенов", "Семен", "Семенович", dateOfBirth, Gender.MALE);
        repository.add(newHuman);
        System.out.println(repository);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        Throwable thrown = Assertions.assertThrows(Exception.class, () -> repository.set(4, newHuman_3));
        assertNotNull(thrown.getMessage());
    }

    /** test finding on surname in repository */
    @Test
    void testFindOnSurname() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("14.05.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1997");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1997");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("14.05.1997");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        RepositoryForHumans find_rep = repository.findOn("Пупкин");
        System.out.println(find_rep);
    }

    /** test finding on date of birth in repository */
    @Test
    void testFindOnDateOfBirth() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(formatter.parseDateTime("14.05.1996"));
        System.out.println(find_rep);
    }

    /** test finding on age in repository */
    @Test
    void testFindOnAge() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(22);
        System.out.println(find_rep);
    }

    /** test finding on not existing surname in repository */
    @Test
    void testFindOnSurnameNothing() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn("Пупкина");
        System.out.println(find_rep);
    }

    /** test finding on not existing date of birth in repository */
    @Test
    void testFindOnDateOfBirthNothing() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(formatter.parseDateTime("14.05.1997"));
        System.out.println(find_rep);
    }

    /** test finding on not existing age in repository */
    @Test
    void testFindOnAgeNothing() {
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        RepositoryForHumans find_rep = repository.findOn(30);
        System.out.println(find_rep);
    }

    /** test bubblesort on surname in repository */
    @Test
    void testBubbleSortSurname() {
        repository.setSorter(new BubbleSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanSurnameComparator());
    }

    /** test insertsort on surname in repository */
    @Test
    void testInsertSortSurname() {
        repository.setSorter(new InsertSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanSurnameComparator());
    }

    /** test shellsort on surname in repository */
    @Test
    void testShellSortSurname() {
        repository.setSorter(new ShellSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanSurnameComparator());
    }

    /** test bubblesort on date of birth in repository */
    @Test
    void testBubbleSortDateOfBirth() {
        repository.setSorter(new BubbleSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanDateOfBirthComparator());
    }

    /** test insertsort on date of birth in repository */
    @Test
    void testInsertSortDateOfBirth() {
        repository.setSorter(new InsertSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanDateOfBirthComparator());
    }

    /** test shellsort on date of birth in repository */
    @Test
    void testShellSortDateOfBirth() {
        repository.setSorter(new ShellSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanDateOfBirthComparator());
    }

    /** test bubblesort on age in repository */
    @Test
    void testBubbleSortAge() {
        repository.setSorter(new BubbleSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanAgeComparator());
    }

    /** test insertsort on age in repository */
    @Test
    void testInsertSortAge() {
        repository.setSorter(new InsertSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanAgeComparator());
    }

    /** test shellsort on age in repository */
    @Test
    void testShellSortAge() {
        repository.setSorter(new ShellSorter());
        DateTime dateOfBirth_1 = formatter.parseDateTime("12.07.1997");
        Human newHuman_1 = new Human("Семенов", "Семен", "Семенович", dateOfBirth_1, Gender.MALE);
        repository.add(newHuman_1);
        DateTime dateOfBirth_2 = formatter.parseDateTime("14.05.1996");
        Human newHuman_2 = new Human("Пупкин", "Василий", "Семенович", dateOfBirth_2, Gender.MALE);
        repository.add(newHuman_2);
        DateTime dateOfBirth_4 = formatter.parseDateTime("14.05.1996");
        Human newHuman_4 = new Human("Пупкин", "Семен", "Семенович", dateOfBirth_4, Gender.MALE);
        repository.add(newHuman_4);
        DateTime dateOfBirth_3 = formatter.parseDateTime("23.05.2000");
        Human newHuman_3 = new Human("Иванов", "Иван", "Иванович", dateOfBirth_3, Gender.MALE);
        repository.add(newHuman_3);
        System.out.println(repository);
        repository.sortBy(new HumanAgeComparator());
    }
}
