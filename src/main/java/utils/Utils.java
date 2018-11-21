package utils;

import human.Human;

/**
 * Класс утилит для различных вспомогательных функций
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class Utils {

    /**
     * Функция, склеивающая два массива людей в один
     * @param humansToConcatOne - первый массив для склеивания
     * @param humansToConcatTwo - второй массив для склеивания
     * @return возвращает склеенный массив людей
     */
    public static Human[] concat(Human[] humansToConcatOne, Human[] humansToConcatTwo) {
        int humansToConcatOneLen = humansToConcatOne.length;
        int humansToConcatTwoLen = humansToConcatTwo.length;
        human.Human[] humansResult = new Human[humansToConcatOneLen+humansToConcatTwoLen];
        System.arraycopy(humansToConcatOne, 0, humansResult, 0, humansToConcatOneLen);
        System.arraycopy(humansToConcatTwo, 0, humansResult, humansToConcatOneLen, humansToConcatTwoLen);
        return humansResult;
    }
}
