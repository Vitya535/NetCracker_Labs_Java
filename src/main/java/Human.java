import org.joda.time.DateTime;
import org.joda.time.Period;
import java.util.Objects;
import static java.lang.String.join;

/**
 * Класс человека с id, ФИО, датой рождения,
 * возрастом
 * @author Кушнеренко Виктор
 * @version 1.1
 */
public class Human
{
    /**
     * Конструктор для создания человека
     * @param surname - фамилия
     * @param name - имя
     * @param patronymic - отчество
     * @param dateOfBirth - дата рождения
     * @param sex - пол
     */
    public Human(String surname, String name, String patronymic, DateTime dateOfBirth, Sex sex)
    {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    /** поле id-шник */
    private int id;

    /**
     * Функция, возвращающая значение поля {@link Human#id}
     * @return возвращает ID человека
     */
    public int getId() {
        return id;
    }

    /**
     * Функция для определения значения поля {@link Human#id}
     * @param id - новый ID человека
     */
    public void setId(int id) {
        this.id = id;
    }

    /** поле для имени человека */
    private String name;

    /**
     * Функция, возвращающая значение поля {@link Human#name}
     * @return возвращает имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Функция для определения значения поля {@link Human#name}
     * @param name - новое имя человека
     */
    public void setName(String name) {
        this.name = name;
    }

    /** поле для фамилии человека */
    private String surname;

    /**
     * Функция, возвращающая значение поля {@link Human#surname}
     * @return возвращает фамилию человека
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Функция для определения значения поля {@link Human#surname}
     * @param surname - новая фамилия человека
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /** поле для отчества человека */
    private String patronymic;

    /**
     * Функция, возвращающая значение поля {@link Human#patronymic}
     * @return возвращает отчество человека
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Функция для определения значения поля {@link Human#patronymic}
     * @param patronymic - новое отчество человека
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Функция, возвращающая значения полей {@link Human#surname}, {@link Human#name}, {@link Human#patronymic}
     * @return возвращает ФИО человека в именительном падеже
     */
    public String getFIO()
    {
        return join(" ", surname, name, patronymic);
    }

    /** поле для даты рождения */
    private DateTime dateOfBirth;

    /**
     * Функция, возвращающая значение поля {@link Human#dateOfBirth}
     * @return возвращает дату рождения человека
     */
    public DateTime getDateOfBirth() { return dateOfBirth; } // подчеркивания !!!

    /**
     * Функция для определения значения поля {@link Human#dateOfBirth}
     * @param dateOfBirth - новая дата рождения человека
     */
    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /** поле для определения пола человека */
    private Sex sex;

    /**
     * Функция для получения пола человека
     * @return возвращает пол человека
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Функция для задания пола человека
     * @param sex - пол, который задается человеку
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Функция, возвращающая значение разности поля {@link Human#dateOfBirth}
     * и нынешнего времени
     * @return возвращает возраст человека
     */
    public int getAge()
    {
        DateTime now = DateTime.now();
        Period difference = new Period(this.dateOfBirth, now);
        return difference.getYears();
    }

    /**
     * Функция, представляющая строковое представление обьекта человека
     * @return возвращает представление обьекта в виде строки
     */
    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth + '\'' +
                ", sex=" + sex +
                '}';
    }

    /**
     * Переопределенный метод equals для класса человека
     * @param o - обьект класса Object (для нас пока класс человека {@link Human}
     * @return возвращает значение, определяющее равны обьекты или нет
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
                Objects.equals(getSex(), human.getSex());
    }

    /**
     * Переопределенный метод hashCode для класса человека
     * @return возвращает хэш-код обьекта человека
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic(), getDateOfBirth(), getSex());
    }
}
