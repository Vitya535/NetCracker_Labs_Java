package checkers;

import human.Human;
import org.apache.log4j.Logger;

/**
 * Class for finding people in repository
 * on date of birth
 *
 * @author Kushnerenko Victor
 * @see Checker
 * @see HumanAgeChecker
 * @see HumanSurnameChecker
 */
public class HumanDateOfBirthChecker implements Checker {
    /**
     * private object of class Logger for logging class HumanDateOfBirthChecker
     */
    private static final Logger logger = Logger.getLogger(Checker.class);

    /**
     * Override method check for finding people in repository
     * on date of birth
     *
     * @param findHuman - human, who we find {@link Human}
     * @param value     - value of some parameter, by which we find him
     * @return returns boolean value, which define is that human who we find or not
     * @see Checker#check(Human, Object)
     * @see HumanAgeChecker#check(Human, Object)
     * @see HumanSurnameChecker#check(Human, Object)
     */
    @Override
    public boolean check(Human findHuman, Object value) {
        logger.debug("method check date of birth invoked with params: " + findHuman + "and " + value);
        return findHuman.getDateOfBirth().equals(value);
    }
}
