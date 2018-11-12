import org.joda.time.DateTime;
import org.joda.time.Period;
import java.util.Objects;
import static java.lang.String.join;

// ToDo - подумать над тем, как хранить ФИО
// ToDo - подумать над получением возраста человека

/**
 * Класс человека с id, ФИО, датой рождения,
 * возрастом
 * @author Кушнеренко Виктор
 * @version 1.1
 */
class Human
{
    /**
     * Конструктор для создания человека
     * @param surname - фамилия
     * @param name - имя
     * @param patronymic - отчество
     * @param date_of_birth - дата рождения
     * @param sex - пол
     */
    Human(String surname, String name, String patronymic, DateTime date_of_birth, Sex sex)
    {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date_of_birth = date_of_birth;
        this.sex = sex;
    }

    /** поле id-шник */
    private int id;

    /**
     * Функция, возвращающая значение поля {@link Human#id}
     * @return возвращает ID человека
     */
    int getId() {
        return id;
    }

    /**
     * Функция для определения значения поля {@link Human#id}
     * @param id - новый ID человека
     */
    void setId(int id) {
        this.id = id;
    }

    /** поле для имени человека */
    private String name;

    /**
     * Функция, возвращающая значение поля {@link Human#name}
     * @return возвращает имя человека
     */
    String getName() {
        return name;
    }

    /**
     * Функция для определения значения поля {@link Human#name}
     * @param name - новое имя человека
     */
    void setName(String name) {
        this.name = name;
    }

    /** поле для фамилии человека */
    private String surname;

    /**
     * Функция, возвращающая значение поля {@link Human#surname}
     * @return возвращает фамилию человека
     */
    String getSurname() {
        return surname;
    }

    /**
     * Функция для определения значения поля {@link Human#surname}
     * @param surname - новая фамилия человека
     */
    void setSurname(String surname) {
        this.surname = surname;
    }

    /** поле для отчества человека */
    private String patronymic;

    /**
     * Функция, возвращающая значение поля {@link Human#patronymic}
     * @return возвращает отчество человека
     */
    String getPatronymic() {
        return patronymic;
    }

    /**
     * Функция для определения значения поля {@link Human#patronymic}
     * @param patronymic - новое отчество человека
     */
    void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Функция, возвращающая значения полей {@link Human#surname}, {@link Human#name}, {@link Human#patronymic}
     * @return возвращает ФИО человека в именительном падеже
     */
    String getFIO()
    {
        return join(" ", surname, name, patronymic);
    }

    /** поле для даты рождения */
    private DateTime date_of_birth;

    /**
     * Функция, возвращающая значение поля {@link Human#date_of_birth}
     * @return возвращает дату рождения человека
     */
    DateTime getDate_of_birth() { return date_of_birth; }

    /**
     * Функция для определения значения поля {@link Human#date_of_birth}
     * @param date_of_birth - новая дата рождения человека
     */
    void setDate_of_birth(DateTime date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /** поле для определения пола человека */
    private Sex sex;

    /**
     * Функция для получения пола человека
     * @return возвращает пол человека
     */
    Sex getSex() {
        return sex;
    }

    /**
     * Функция для задания пола человека
     * @param sex - пол, который задается человеку
     */
    void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Функция, возвращающая значение разности поля {@link Human#date_of_birth}
     * и нынешнего времени
     * @return возвращает возраст человека
     */
    int getAge()
    {
        DateTime now = DateTime.now();
        Period difference = new Period(this.date_of_birth, now);
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
                ", date_of_birth=" + date_of_birth + '\'' +
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
                Objects.equals(getDate_of_birth(), human.getDate_of_birth()) &&
                Objects.equals(getSex(), human.getSex());
    }

    /**
     * Переопределенный метод hashCode для класса человека
     * @return возвращает хэш-код обьекта человека
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic(), getDate_of_birth(), getSex());
    }
}
