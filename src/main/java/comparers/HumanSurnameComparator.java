package comparers;

import human.Human;

import java.util.Comparator;

/**
 * Класс компаратора для сравнения людей в репозитории
 * по фамилии
 * @see HumanAgeComparator
 * @see HumanDateOfBirthComparator
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class HumanSurnameComparator implements Comparator<Human> {

    /**
     * Функция сравнения двух людей
     * в репозитории по фамилии
     * @param o1 - первый человек, которого мы сравниваем
     * @param o2 - второй человек, которого мы сравниваем
     * @return возвращает 1, если фамилия первого больше, чем второго
     * возвращает -1, если фамилия первого меньше, чем второго
     * возвращает 0, если фамилии одинаковы
     * @see HumanDateOfBirthComparator#compare(Human, Human)
     * @see HumanAgeComparator#compare(Human, Human)
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
