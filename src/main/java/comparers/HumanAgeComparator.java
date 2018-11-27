package comparers;

import human.Human;

import java.util.Comparator;

/**
 * Class of comparator for comprehend people in repository
 * on age
 * @see HumanDateOfBirthComparator
 * @see HumanSurnameComparator
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class HumanAgeComparator implements Comparator<Human> {

    /**
     * Function for comprehend two humans
     * in repository on age
     * @param o1 - first human, who we comprehend
     * @param o2 - second human, who we comprehend
     * @return return 1, if age of first human more, than second one
     * return -1, if age of first human less, than second one
     * return 0, if age of humans is equal
     * @see HumanDateOfBirthComparator#compare(Human, Human)
     * @see HumanSurnameComparator#compare(Human, Human)
     */
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
