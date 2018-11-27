package utils;

import human.Human;

/**
 * Utils class for various support functions
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class Utils {

    /**
     * Function, concat two arrays of people in one
     * @param humansToConcatOne - first array for concat
     * @param humansToConcatTwo - second array for concat
     * @return return concat array of people
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
