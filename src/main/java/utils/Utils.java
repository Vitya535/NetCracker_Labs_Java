package utils;

import human.Human;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Utils class for various support functions
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class Utils {

    /** private object of class Logger for logging class Utils*/
    private static final Logger logger = Logger.getLogger(Utils.class);

    /**
     * Function, concat two arrays of people in one
     * @param humansToConcatOne - first array for concat
     * @param humansToConcatTwo - second array for concat
     * @return return concat array of people
     */
    public static Human[] concat(Human[] humansToConcatOne, Human[] humansToConcatTwo) {
        logger.debug("method concat invoked with params: " + Arrays.toString(humansToConcatOne) + "and " + Arrays.toString(humansToConcatTwo));
        int humansToConcatOneLen = humansToConcatOne.length;
        int humansToConcatTwoLen = humansToConcatTwo.length;
        if (humansToConcatOneLen == 0 || humansToConcatTwoLen == 0)
            logger.warn("the humansToConcatOneLen is: " + humansToConcatOneLen + "and humansToConcatTwoLen: " +
                        humansToConcatTwoLen + " exception may occur");
        logger.info("init new array with sum of two lengths: " + humansToConcatOneLen + "and " + humansToConcatTwoLen);
        Human[] humansResult = new Human[humansToConcatOneLen + humansToConcatTwoLen];
        logger.info("arraycopy from 0 to " + humansToConcatOneLen);
        System.arraycopy(humansToConcatOne, 0, humansResult, 0, humansToConcatOneLen);
        logger.info("arraycopy from " + humansToConcatOneLen + "to " + humansToConcatTwoLen);
        System.arraycopy(humansToConcatTwo, 0, humansResult, humansToConcatOneLen, humansToConcatTwoLen);
        return humansResult;
    }
}
