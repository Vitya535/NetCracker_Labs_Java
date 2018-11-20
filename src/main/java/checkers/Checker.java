package checkers;

import human.Human;

/**
 * Интерфейс Checker для поиска людей в
 * репозитории по определенному параметру
 * @see HumanAgeChecker
 * @see HumanDateOfBirthChecker
 * @see HumanSurnameChecker
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public interface Checker
{
    /**
     * Сигнатура метода для поиска людей
     * @param findHuman - человек, которого мы ищем {@link Human}
     * @param value - значение некоторого параметра, по которому мы его ищем
     * @return возвращает boolean-значение, обозначающее тот ли это человек, которого мы ищем или нет
     * @see HumanAgeChecker#check(Human, Object)
     * @see HumanSurnameChecker#check(Human, Object)
     * @see HumanDateOfBirthChecker#check(Human, Object)
     */
    boolean check(Human findHuman, Object value);
}
