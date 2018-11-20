package comparers;

import human.Human;

import java.util.Comparator;

/**
 * Класс компаратора для сравнения людей в репозитории
 * по дате рождения
 * @see HumanAgeComparator
 * @see HumanSurnameComparator
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class HumanDateOfBirthComparator implements Comparator<Human> {

    /**
     * Функция сравнения двух людей
     * в репозитории по дате рождения
     * @param o1 - первый человек, которого мы сравниваем
     * @param o2 - второй человек, которого мы сравниваем
     * @return возвращает 1, если дата рождения первого больше, чем второго
     * возвращает -1, если дата рождения первого меньше, чем второго
     * возвращает 0, если даты рождения одинаковы
     * @see HumanAgeComparator#compare(Human, Human)
     * @see HumanSurnameComparator#compare(Human, Human)
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
