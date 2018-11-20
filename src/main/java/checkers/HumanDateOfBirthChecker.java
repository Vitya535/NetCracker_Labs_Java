package checkers;

import human.Human;

/**
 * Класс для поиска людей в репозитории
 * по возрасту
 * @see Checker
 * @see HumanAgeChecker
 * @see HumanSurnameChecker
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class HumanDateOfBirthChecker implements Checker
{
    /**
     * Перекрытие метода check для поиска людей в репозитории
     * по дате рождения
     * @see Checker#check(Human, Object)
     * @see HumanAgeChecker#check(Human, Object)
     * @see HumanSurnameChecker#check(Human, Object)
     * @param findHuman - человек, которого мы ищем {@link Human}
     * @param value - значение некоторого параметра, по которому мы его ищем
     * @return возвращает boolean-значение, обозначающее тот ли это человек, которого мы ищем или нет
     */
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getDateOfBirth().equals(value);
    }
}
