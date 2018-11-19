package repository;

import org.joda.time.DateTime;
import checkers.*;
import human.Human;
import sorters.ShellSorter;
import sorters.Sorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Класс репозитория для людей {@link Human}
 * @author Кушнеренко Виктор
 * @version 1.1
 */
public class RepositoryForHumans
{
    /** поле с массивом из людей {@link Human}*/
    private Human[] arrayOfHumans;

    /** статическое поле для задания новому человеку уникального ID */
    private static int Id = 1;

    /** поле для количества людей в репозитории */
    private int count;

    private Sorter sorter;
    /**
     * Конструктор для репозитория людей
     * Создает пустой массив
     * @see RepositoryForHumans#RepositoryForHumans(Human[])
     */
    public RepositoryForHumans()
    {
        arrayOfHumans = new Human[0];
        count = 0;
        sorter = new ShellSorter();
    }

    public RepositoryForHumans(Sorter new_sorter)
    {
        arrayOfHumans = new Human[0];
        count = 0;
        sorter = new_sorter;
    }

    /**
     * Конструктор для репозитория из людей
     * на основе некоторого массива
     * @param array - некоторый массив из людей
     * @see RepositoryForHumans#RepositoryForHumans()
     */
    public RepositoryForHumans(Human[] array)
    {
        arrayOfHumans = array;
        count = array.length;
        sorter = new ShellSorter();
    }

    public RepositoryForHumans(Human[] array, Sorter new_sorter)
    {
        arrayOfHumans = array;
        count = array.length;
        sorter = new_sorter;
    }

    /**
     * Функция, возвращающая количество элементов в репозитории
     * @return возвращает количество элементов
     */
    public int Count()
    {
        return count;
    }

    /**
     * Функция, проверяющая наличие человека в репозитории
     * @param newHuman - человек, которого необходимо проверить
     * @return возвращает результат проверки
     */
    private boolean isHumanInRepository(Human newHuman)
    {
        return Arrays.stream(arrayOfHumans)
                .anyMatch(human -> human.equals(newHuman) && human.hashCode() == newHuman.hashCode());
    }

    /**
     * Функция добавления в конец репозитория нового человека
     * @param newHuman - человек, который должен быть добавлен в репозиторий
     */
    public void add(Human newHuman)
    {
        if (!isHumanInRepository(newHuman))
        {
            newHuman.setId(Id);
            Human[] newArrayOfHumans = Arrays.copyOf(arrayOfHumans, arrayOfHumans.length + 1);
            newArrayOfHumans[arrayOfHumans.length] = newHuman;
            arrayOfHumans = newArrayOfHumans;
            count++;
            Id++;
        }
    }

    /**
     * Функция добавления в конец репозитория нескольких новых людей
     * @param newHumans - люди, которые должны быть добавлены в репозиторий
     */
    public void addRange(Human[] newHumans)
    {
        Human[] newArrayOfHumans = Arrays.copyOf(arrayOfHumans, arrayOfHumans.length + newHumans.length);
        System.arraycopy(newHumans, 0, newArrayOfHumans, arrayOfHumans.length, newHumans.length);
        arrayOfHumans = newArrayOfHumans;
        count += newHumans.length;
    }

    /**
     * Удаление первое вхождение обьекта человека из репозитория
     * @param humanForDelete - обьект человека, который нужно удалить
     */
    public void remove(Human humanForDelete)
    {
        int index = IntStream.range(0, arrayOfHumans.length)
                .filter(i -> arrayOfHumans[i].equals(humanForDelete))
                .findFirst().orElse(-1);
        Human[] newArrayOfHumans = new Human[arrayOfHumans.length - 1];
        IntStream.range(0, arrayOfHumans.length)
                .filter(i -> index != i)
                .forEach(i -> newArrayOfHumans[i] = arrayOfHumans[i]);
        arrayOfHumans = newArrayOfHumans;
        count--;
    }

    /**
     * Функция удаления человека из репозитория по указанному индексу
     * @param index - индекс, по которому необходимо удалить человека
     */
    public void removeAt(int index)
    {
        Human[] newArrayOfHumans = new Human[arrayOfHumans.length - 1];
        IntStream.range(0, arrayOfHumans.length)
                .filter(i -> index != i)
                .forEach(i -> newArrayOfHumans[i] = arrayOfHumans[i]);
        arrayOfHumans = newArrayOfHumans;
        count--;
    }

    /**
     * Функция для получения человека из репозитория по указанному индексу
     * @param index - индекс, по которому необходимо получить человека
     * @return возвращает обьект человека из репозитория
     */
    public Human get(int index)
    {
        return arrayOfHumans[index];
    }

    public void set(int index, Human human) { arrayOfHumans[index] = human; }

    private RepositoryForHumans find(Checker checker, Object value)
    {
        RepositoryForHumans findHumans = new RepositoryForHumans();
        for (Human human : arrayOfHumans) {
            if (checker.check(human, value)){
               findHumans.add(human);
            }
        }
        return findHumans;
    }

    public RepositoryForHumans findOn(String surname) {
        return find(new HumanSurnameChecker(), surname);
    }

    public RepositoryForHumans findOn(DateTime datetime){
        return find(new HumanDateOfBirthChecker(), datetime);
    }

    public RepositoryForHumans findOn(int age) {
        return find(new HumanAgeChecker(), age);
    }

    public void sortBy(Comparator<Human> comparator) {
        sorter.sort(this, comparator);
    }

    /**
     * Строковое представление репозитория людей
     * @return возвращает представление класса в виде строки
     */
    @Override
    public String toString() {
        return "repository.RepositoryForHumans{" +
                "arrayOfHumans=" + Arrays.toString(arrayOfHumans) +
                '}';
    }

    /**
     * Функция сравнения двух репозиториев
     * @param o - обьект класса репозитория
     * @return возвращает результат сравнения в виде true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryForHumans that = (RepositoryForHumans) o;
        return Arrays.equals(arrayOfHumans, that.arrayOfHumans);
    }

    /**
     * Переопределенный метод hashCode для класса репозитория человека
     * @return возвращает хэш-код обьекта репозитория человека
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayOfHumans);
    }
}
