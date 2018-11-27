package human;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.Objects;

import static java.lang.String.join;

/**
 * Class of human with id, full name, date of birth, age
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class Human
{
    /**
     * Constructor for creating humans
     * @param surname - the human surname
     * @param name - the human name
     * @param patronymic - the human patronymic
     * @param dateOfBirth - the human date of birth
     * @param gender - the gender of human
     */
    public Human(String surname, String name, String patronymic, DateTime dateOfBirth, Gender gender)
    {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    /** the field ID */
    private int id;

    /**
     * Function, returning the value of field {@link Human#id}
     * @return returns human ID
     */
    public int getId() {
        return id;
    }

    /**
     * Function for define the value of field {@link Human#id}
     * @param id - new human ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /** field for name of human */
    private String name;

    /**
     * Function, returning the value of field {@link Human#name}
     * @return returns human name
     */
    public String getName() {
        return name;
    }

    /**
     * Function for define the value of field {@link Human#name}
     * @param name - new human name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** field for human surname */
    private String surname;

    /**
     * Function, returning the value of field {@link Human#surname}
     * @return returns human surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Function for define the value of field {@link Human#surname}
     * @param surname - new surname of human
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /** field for human patronymic */
    private String patronymic;

    /**
     * Function, returning the value of field {@link Human#patronymic}
     * @return returns human patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Function for define the value of field {@link Human#patronymic}
     * @param patronymic - new human patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Function, returning the value of fields {@link Human#surname}, {@link Human#name}, {@link Human#patronymic}
     * @return returns full name of human in nominative case
     */
    public String getFIO()
    {
        return join(" ", surname, name, patronymic);
    }

    /** field for date of birth */
    private DateTime dateOfBirth;

    /**
     * Function, returning the value of field {@link Human#dateOfBirth}
     * @return return human date of birth
     */
    public DateTime getDateOfBirth() { return dateOfBirth; } // подчеркивания !!!

    /**
     * Function for define the value of field {@link Human#dateOfBirth}
     * @param dateOfBirth - new date of birth for human
     */
    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /** field for defining gender of human */
    private Gender gender;

    /**
     * Function for getting gender of human
     * @return return gender of human
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Function for setting gender of human
     * @param gender - gender, which sets to human
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Function, returning the difference of human date of birth {@link Human#dateOfBirth}
     * and current time
     * @return return age of human
     */
    public int getAge()
    {
        DateTime now = DateTime.now();
        Period difference = new Period(this.dateOfBirth, now);
        return difference.getYears();
    }

    /**
     * Function, which representing string view of human object
     * @return return object view in string format
     */
    @Override
    public String toString() {
        return "human.Human{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth + '\'' +
                ", gender=" + gender +
                '}';
    }

    /**
     * Override method equals for human class
     * @param o - object of class Object (for us it's human class {@link Human}
     * @return return value, which define is objects equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(getName(), human.getName()) &&
                Objects.equals(getSurname(), human.getSurname()) &&
                Objects.equals(getPatronymic(), human.getPatronymic()) &&
                Objects.equals(getDateOfBirth(), human.getDateOfBirth()) &&
                getGender() == human.getGender();
    }

    /**
     * Override method hashCode for human class
     * @return return hashCode of human object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic(), getDateOfBirth(), getGender());
    }
}
