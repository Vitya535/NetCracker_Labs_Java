
// ToDo - подумать над тем, как сделать расширяемый массив

import java.util.Arrays;

/**
 * Класс репозитория для людей {@link Human}
 * @author Кушнеренко Виктор
 * @version 1.0
 */
class Repository_For_Humans
{
    /** поле с массивом из людей {@link Human}*/
    private Human[] array_of_humans;

    /**
     * Конструктор для репозитория людей
     * Создает пустой массив
     * @see Repository_For_Humans#Repository_For_Humans(Human[])
     */
    Repository_For_Humans()
    {
        array_of_humans = new Human[0];
    }

    /**
     * Конструктор для репозитория из людей
     * на основе некоторого массива
     * @param array - некоторый массив из людей
     * @see Repository_For_Humans#Repository_For_Humans()
     */
    Repository_For_Humans(Human[] array)
    {
        array_of_humans = array;
    }

    /**
     * Функция, возвращающая массив из людей в репозитории
     * @return возвращает массив людей
     */
    public Human[] get_Array_of_humans() {
        return array_of_humans;
    }

    /**
     * Функция, изменяющая массив людей на новый
     * @param array_of_humans - новый массив из людей
     */
    public void set_Array_of_humans(Human[] array_of_humans) {
        this.array_of_humans = array_of_humans;
    }

    /**
     * Функция добавления в массив нового человека
     * @param new_human - человек, который должен быть добавлен в массив
     */
    void Add(Human new_human)
    {
        Human[] new_array_of_humans = Arrays.copyOf(array_of_humans, array_of_humans.length + 1);
        new_array_of_humans[array_of_humans.length] = new_human;
        array_of_humans = new_array_of_humans;
    }

    /**
     * Удаление человека из массива
     */
    public void Delete()
    {
        array_of_humans = Arrays.copyOf(array_of_humans, array_of_humans.length - 1);
    }

    /**
     * Строковое представление репозитория людей
     * @return возвращает представление класса в виде строки
     */
    @Override
    public String toString() {
        return "Repository_For_Humans{" +
                "array_of_humans=" + Arrays.toString(array_of_humans) +
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
        Repository_For_Humans that = (Repository_For_Humans) o;
        return Arrays.equals(array_of_humans, that.array_of_humans);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array_of_humans);
    }
}
