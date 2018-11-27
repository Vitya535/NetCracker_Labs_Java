package repository;

import checkers.Checker;
import checkers.HumanAgeChecker;
import checkers.HumanDateOfBirthChecker;
import checkers.HumanSurnameChecker;
import human.Human;
import org.joda.time.DateTime;
import sorters.ShellSorter;
import sorters.Sorter;
import utils.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Class repository for humans {@link Human}
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class RepositoryForHumans
{
    /** field with array of humans {@link Human}*/
    private Human[] arrayOfHumans;

    /** static field for set new human unique ID */
    private int id = 1;

    /** Field for count people in repository */
    private int repCount;

    /** field for object of class Sorter {@link Sorter}*/
    private Sorter sorter;

    /**
     * Constructor for repository of humans
     * Creating empty array with ShellSorter on default {@link ShellSorter}
     * @see RepositoryForHumans#RepositoryForHumans(Human[])
     * @see RepositoryForHumans#RepositoryForHumans(Human[], Sorter)
     * @see RepositoryForHumans#RepositoryForHumans(Sorter)
     */
    public RepositoryForHumans()
    {
        arrayOfHumans = new Human[0];
        repCount = 0;
        sorter = new ShellSorter();
    }

    /**
     * Constructor for repository of humans
     * Creating empty array with Sorter new_sorter {@link Sorter}
     * @param new_sorter - sorter, setting to repository
     * @see RepositoryForHumans#RepositoryForHumans(Human[])
     * @see RepositoryForHumans#RepositoryForHumans(Human[], Sorter)
     * @see RepositoryForHumans#RepositoryForHumans()
     */
    public RepositoryForHumans(Sorter new_sorter)
    {
        arrayOfHumans = new Human[0];
        repCount = 0;
        sorter = new_sorter;
    }

    /**
     * Constructor for repository of humans
     * based on some array
     * with ShellSorter on default
     * @param array - some array with people
     * @see RepositoryForHumans#RepositoryForHumans()
     * @see RepositoryForHumans#RepositoryForHumans(Human[], Sorter)
     * @see RepositoryForHumans#RepositoryForHumans(Sorter)
     */
    public RepositoryForHumans(Human[] array)
    {
        arrayOfHumans = array;
        repCount = array.length;
        sorter = new ShellSorter();
    }

    /**
     * Constructor for repository of humans
     * based on some array
     * with Sorter new_sorter {@link Sorter}
     * @param array - some array with people
     * @param new_sorter - sorter, setting to repository
     * @see RepositoryForHumans#RepositoryForHumans()
     * @see RepositoryForHumans#RepositoryForHumans(Sorter)
     * @see RepositoryForHumans#RepositoryForHumans(Human[])
     */
    public RepositoryForHumans(Human[] array, Sorter new_sorter)
    {
        arrayOfHumans = array;
        repCount = array.length;
        sorter = new_sorter;
    }

    /**
     * Function, returning count of elements in repository
     * @return return count of elements
     */
    public int count()
    {
        return repCount;
    }

    /**
     * Function, returning object of Sorter repository {@link Sorter}
     * @return return Sorter of repository
     */
    public Sorter getSorter() {
        return sorter;
    }

    /**
     * Function, setting object of Sorter repository {@link Sorter}
     * @param sorter - new Sorter of repository
     */
    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    /**
     * Function, checking is human in repository
     * @param newHuman - human, who need to check
     * @return return result of check
     */
    private boolean isHumanInRepository(Human newHuman)
    {
        return Arrays.stream(arrayOfHumans)
                .anyMatch(human -> human.equals(newHuman) && human.hashCode() == newHuman.hashCode());
    }

    /**
     * Function, adding in the end of repository existing human
     * made for use in the finding people {@link RepositoryForHumans#find(Checker, Object)}
     * @param existingHuman - human, who need to add in repository
     */
    private void addExistingHuman(Human existingHuman) {
        Human[] newArrayOfHumans = Arrays.copyOf(arrayOfHumans, arrayOfHumans.length + 1);
        newArrayOfHumans[arrayOfHumans.length] = existingHuman;
        arrayOfHumans = newArrayOfHumans;
        repCount++;
    }

    /**
     * Function, adding in the end of repository new human
     * @param newHuman - human, who need to add in repository
     */
    public void add(Human newHuman)
    {
        if (!isHumanInRepository(newHuman))
        {
            newHuman.setId(id);
            Human[] newArrayOfHumans = Arrays.copyOf(arrayOfHumans, arrayOfHumans.length + 1);
            newArrayOfHumans[arrayOfHumans.length] = newHuman;
            arrayOfHumans = newArrayOfHumans;
            repCount++;
            id++;
        }
    }

    /**
     * Function, adding in the end of repository several new humans
     * @param newHumans - humans, who need to add in repository
     */
    public void addRange(Human[] newHumans)
    {
        for (Human newHuman : newHumans)
            this.add(newHuman);
    }

    /**
     * Remove first entry object of human from repository
     * @param humanForDelete - object of human, who need to delete
     */
    public void remove(Human humanForDelete)
    {
        int index = IntStream.range(0, arrayOfHumans.length)
                .filter(i -> arrayOfHumans[i].equals(humanForDelete))
                .findFirst().orElse(-1);
        removeAt(index);
    }

    /**
     * Function of delete human from repository on pointed index
     * @param index - index, by which we need to delete human
     */
    public void removeAt(int index)
    {
        arrayOfHumans = Utils.concat(Arrays.copyOfRange(arrayOfHumans, 0, index),
                        Arrays.copyOfRange(arrayOfHumans, index + 1, arrayOfHumans.length));
        repCount--;
    }

    /**
     * Function for getting human from repository on pointed index
     * @param index - index, by which we need to get human
     * @return return object of human from repository
     */
    public Human get(int index)
    {
        return arrayOfHumans[index];
    }

    /**
     *  Function for setting human from repository on pointed index
     * @param index - index, by which we need to set human
     * @param human - new human, which set on index
     */
    public void set(int index, Human human) {
        //int newId = arrayOfHumans[index].getId();
        if (human.getId() == 0)
            human.setId(arrayOfHumans[index].getId());
        arrayOfHumans[index] = human;
        //arrayOfHumans[index].setId(newId);
    }

    /**
     * Function for finding people on concrete
     * value of some parameter
     * @param checker - object of Checker, which find human on value of some parameter {@link Checker}
     * @param value - value of parameter, by which we comprehend each human in repository
     * @return return new repository of finded people
     */
    private RepositoryForHumans find(Checker checker, Object value)
    {
        RepositoryForHumans findHumans = new RepositoryForHumans();
        for (Human human : arrayOfHumans) {
            if (checker.check(human, value)){
               findHumans.addExistingHuman(human);
            }
        }
        return findHumans;
    }

    /**
     * Function-wrapper for find people on surname
     * @see RepositoryForHumans#find(Checker, Object)
     * @see RepositoryForHumans#findOn(DateTime)
     * @see RepositoryForHumans#findOn(int)
     * @param surname - value of surname, by which we find humans
     * @return return new repository of finded people
     */
    public RepositoryForHumans findOn(String surname) {
        return find(new HumanSurnameChecker(), surname);
    }

    /**
     * Function-wrapper for find people on date of birth
     * @see RepositoryForHumans#find(Checker, Object)
     * @see RepositoryForHumans#findOn(String)
     * @see RepositoryForHumans#findOn(int)
     * @param datetime - value of date of birth, by which we find humans
     * @return return new repository of finded people
     */
    public RepositoryForHumans findOn(DateTime datetime){
        return find(new HumanDateOfBirthChecker(), datetime);
    }

    /**
     * Function-wrapper for find people on age
     * @see RepositoryForHumans#find(Checker, Object)
     * @see RepositoryForHumans#findOn(String)
     * @see RepositoryForHumans#findOn(DateTime)
     * @param age - value of age, by which we find humans
     * @return return new repository of finded people
     */
    public RepositoryForHumans findOn(int age) {
        return find(new HumanAgeChecker(), age);
    }

    /**
     * Function-wrapper for sorting people on concrete value
     * of some parameter
     * @param comparator - comparator, by which we sorting people {@link Comparator}
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     */
    public void sortBy(Comparator<Human> comparator) {
        sorter.sort(this, comparator);
    }

    /**
     * String representation of human repository
     * @return return string representation
     */
    @Override
    public String toString() {
        return "repository.RepositoryForHumans{" +
                "arrayOfHumans=" + Arrays.toString(arrayOfHumans) +
                '}';
    }

    /**
     * Function for comprehend two repositories
     * @param o - object of Repository class
     * @return return result of comprehend - true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryForHumans that = (RepositoryForHumans) o;
        return Arrays.equals(arrayOfHumans, that.arrayOfHumans);
    }

    /**
     * Override method hashCode for class of human repository
     * @return return hashCode of object of human repository
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayOfHumans);
    }
}
