package comparers;

import human.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * Class of comparator for comprehend people in repository
 * on surname
 *
 * @author Kushnerenko Victor
 * @see HumanAgeComparator
 * @see HumanDateOfBirthComparator
 */
public class HumanSurnameComparator implements Comparator<Human> {

    /**
     * private object of class Logger for logging class HumanSurnameComparator
     */
    private static final Logger logger = LogManager.getLogger(Comparator.class);

    /**
     * Function for comprehend two people
     * in repository on surname
     *
     * @param o1 - first human, who we comprehend
     * @param o2 - second human, who we comprehend
     * @return return 1, if surname of first human more, than second one
     * return -1, if surname of first human less, than second one
     * return 0, if surnames of humans is equal
     * @see HumanDateOfBirthComparator#compare(Human, Human)
     * @see HumanAgeComparator#compare(Human, Human)
     */
    @Override
    public int compare(Human o1, Human o2) {
        logger.debug("method compare on surname invoked with params: " + o1 + "and " + o2);
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
