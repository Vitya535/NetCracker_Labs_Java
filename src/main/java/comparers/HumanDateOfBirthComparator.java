package comparers;

import human.Human;

import java.util.Comparator;

/**
 * Class of comparator for comprehend people in repository
 * on date of birth
 * @see HumanAgeComparator
 * @see HumanSurnameComparator
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class HumanDateOfBirthComparator implements Comparator<Human> {

    /**
     * Function for comprehend two humans
     * in repository on date of birth
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
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
