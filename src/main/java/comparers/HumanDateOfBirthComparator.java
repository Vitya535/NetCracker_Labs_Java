package comparers;

import human.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * Class of comparator for comprehend people in repository
 * on date of birth
 *
 * @author Kushnerenko Victor
 * @see HumanAgeComparator
 * @see HumanSurnameComparator
 */
public class HumanDateOfBirthComparator implements Comparator<Human> {

    /**
     * private object of class Logger for logging class HumanDateOfBirthComparator
     */
    private static final Logger logger = LogManager.getLogger(Comparator.class);

    /**
     * Function for comprehend two humans
     * in repository on date of birth
     *
     * @param o1 - first human, who we comprehend
     * @param o2 - second human, who we comprehend
     * @return return 1, if date of birth of first human more, than second one
     * return -1, if date of birth of first human less, than second one
     * return 0, if date of birth is equal
     * @see HumanAgeComparator#compare(Human, Human)
     * @see HumanSurnameComparator#compare(Human, Human)
     */
    @Override
    public int compare(Human o1, Human o2) {
        logger.debug("method compare on date of birth invoked with params: " + o1 + "and " + o2);
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
