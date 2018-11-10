
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
    private int count;

    /**
     * Конструктор для репозитория людей
     * Создает пустой массив
     * @see Repository_For_Humans#Repository_For_Humans(Human[])
     */
    Repository_For_Humans()
    {
        array_of_humans = new Human[0];
        count = 0;
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
        count = array.length;
    }

    /**
     * Функция, возвращающая количество элементов в репозитории
     * @return возвращает количество элементов
     */
    int Count()
    {
        return array_of_humans.length;
    }

    /**
     * Функция добавления в конец репозитория нового человека
     * @param new_human - человек, который должен быть добавлен в репозиторий
     */
    void Add(Human new_human)
    {
        Human[] new_array_of_humans = Arrays.copyOf(array_of_humans, array_of_humans.length + 1);
        new_array_of_humans[array_of_humans.length] = new_human;
        array_of_humans = new_array_of_humans;
        count += 1;
    }

    /**
     * Функция добавления в конец репозитория нескольких новых людей
     * @param new_humans - люди, которые должны быть добавлены в репозиторий
     */
    void AddRange(Human[] new_humans)
    {
        Human[] new_array_of_humans = Arrays.copyOf(array_of_humans, array_of_humans.length + new_humans.length);
        System.arraycopy(new_humans, 0, new_array_of_humans, array_of_humans.length, array_of_humans.length + new_humans.length - array_of_humans.length);
        array_of_humans = new_array_of_humans;
        count += new_humans.length;
    }

    /**
     * Удаление первое вхождение обьекта человека из репозитория
     * @param human_for_delete - обьект человека, который нужно удалить
     */
    void Remove(Human human_for_delete)
    {
        int index = -1;
        for (int i = 0; i < array_of_humans.length; i++)
            if (array_of_humans[i].equals(human_for_delete)) {
                index = i;
                break;
            }
        Human[] new_array_of_humans = new Human[array_of_humans.length - 1];
        for (int i = 0; i < array_of_humans.length; i++)
            if (index != i)
                new_array_of_humans[i] = array_of_humans[i];
        array_of_humans = new_array_of_humans;
        count -= 1;
    }

    /**
     * Функция удаления человека из репозитория по указанному индексу
     * @param index - индекс, по которому необходимо удалить человека
     */
    void RemoveAt(int index)
    {
        Human[] new_array_of_humans = new Human[array_of_humans.length - 1];
        for (int i = 0; i < array_of_humans.length; i++)
            if (index != i)
                new_array_of_humans[i] = array_of_humans[i];
        array_of_humans = new_array_of_humans;
        count -= 1;
    }

    /**
     * Функция для получения человека из репозитория по указанному индексу
     * @param index - индекс, по которому необходимо получить человека
     * @return возвращает обьект человека из репозитория
     */
    Human Get(int index)
    {
        return array_of_humans[index];
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

    /**
     * Переопределенный метод hashCode для класса репозитория человека
     * @return возвращает хэш-код обьекта репозитория человека
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(array_of_humans);
    }
}
