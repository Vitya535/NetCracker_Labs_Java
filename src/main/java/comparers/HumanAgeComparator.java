package comparers;

import human.Human;

import java.util.Comparator;

/**
 * Класс компаратора для сравнения людей в репозитории
 * по возрасту
 * @see HumanDateOfBirthComparator
 * @see HumanSurnameComparator
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class HumanAgeComparator implements Comparator<Human> {

    /**
     * Функция сравнения двух людей
     * в репозитории по возрасту
     * @param o1 - первый человек, которого мы сравниваем
     * @param o2 - второй человек, которого мы сравниваем
     * @return возвращает 1, если возраст первого больше, чем второго
     * возвращает -1, если возраст первого меньше, чем второго
     * возвращает 0, если возраст одинаков
     * @see HumanDateOfBirthComparator#compare(Human, Human)
     * @see HumanSurnameComparator#compare(Human, Human)
     */
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
