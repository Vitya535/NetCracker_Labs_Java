package human;

import org.apache.log4j.Logger;
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
        logger.debug("init human object with params: " + join(",", surname, name, patronymic, dateOfBirth.toString(), gender.toString()));
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    /** private object of class Logger for logging class Human */
    private static final Logger logger = Logger.getLogger(Human.class);

    /** the field ID */
    private int id;

    /**
     * Function, returning the value of field {@link Human#id}
     * @return returns human ID
     */
    public int getId() {
        logger.debug("return id of human");
        return id;
    }

    /**
     * Function for define the value of field {@link Human#id}
     * @param id - new human ID
     */
    public void setId(int id) {
        logger.debug("set id of human: " + id);
        this.id = id;
    }

    /** field for name of human */
    private String name;

    /**
     * Function, returning the value of field {@link Human#name}
     * @return returns human name
     */
    public String getName() {
        logger.debug("get name of human");
        return name;
    }

    /**
     * Function for define the value of field {@link Human#name}
     * @param name - new human name
     */
    public void setName(String name) {
        logger.debug("set name of human: " + name);
        this.name = name;
    }

    /** field for human surname */
    private String surname;

    /**
     * Function, returning the value of field {@link Human#surname}
     * @return returns human surname
     */
    public String getSurname() {
        logger.debug("get surname of human");
        return surname;
    }

    /**
     * Function for define the value of field {@link Human#surname}
     * @param surname - new surname of human
     */
    public void setSurname(String surname) {
        logger.debug("set surname of human: " + surname);
        this.surname = surname;
    }

    /** field for human patronymic */
    private String patronymic;

    /**
     * Function, returning the value of field {@link Human#patronymic}
     * @return returns human patronymic
     */
    public String getPatronymic() {
        logger.debug("get patronymic of human");
        return patronymic;
    }

    /**
     * Function for define the value of field {@link Human#patronymic}
     * @param patronymic - new human patronymic
     */
    public void setPatronymic(String patronymic) {
        logger.debug("set patronymic of human: " + patronymic);
        this.patronymic = patronymic;
    }

    /**
     * Function, returning the value of fields {@link Human#surname}, {@link Human#name}, {@link Human#patronymic}
     * @return returns full name of human in nominative case
     */
    public String getFIO()
    {
        logger.debug("get full name of human");
        return join(" ", surname, name, patronymic);
    }

    /** field for date of birth */
    private DateTime dateOfBirth;

    /**
     * Function, returning the value of field {@link Human#dateOfBirth}
     * @return return human date of birth
     */
    public DateTime getDateOfBirth() {
        logger.debug("get date of birth of human");
        return dateOfBirth;
    }

    /**
     * Function for define the value of field {@link Human#dateOfBirth}
     * @param dateOfBirth - new date of birth for human
     */
    public void setDateOfBirth(DateTime dateOfBirth) {
        logger.debug("set date of birth of human: " + dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    /** field for defining gender of human */
    private Gender gender;

    /**
     * Function for getting gender of human
     * @return return gender of human
     */
    public Gender getGender() {
        logger.debug("get gender of human");
        return gender;
    }

    /**
     * Function for setting gender of human
     * @param gender - gender, which sets to human
     */
    public void setGender(Gender gender) {
        logger.debug("set gender of human: " + gender);
        this.gender = gender;
    }

    /**
     * Function, returning the difference of human date of birth {@link Human#dateOfBirth}
     * and current time
     * @return return age of human
     */
    public int getAge()
    {
        logger.debug("get age of human");
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
        logger.debug("convert human to string representation");
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
        logger.debug("method equals invoked with params: " + o);
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
        logger.debug("method hashCode invoked");
        return Objects.hash(getName(), getSurname(), getPatronymic(), getDateOfBirth(), getGender());
    }
}
