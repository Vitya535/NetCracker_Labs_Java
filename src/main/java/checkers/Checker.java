package checkers;

import human.Human;

/**
 * Interface Checker for finding people in
 * repository on definite parameter
 * @see HumanAgeChecker
 * @see HumanDateOfBirthChecker
 * @see HumanSurnameChecker
 * @author Kushnerenko Victor
 * @version 1.2
 */
public interface Checker
{
    /**
     * Signature of method for finding people
     * @param findHuman - human, who we find {@link Human}
     * @param value - value of some parameter, by which we find people
     * @return returns boolean value, which define is that human who we find or not
     * @see HumanAgeChecker#check(Human, Object)
     * @see HumanSurnameChecker#check(Human, Object)
     * @see HumanDateOfBirthChecker#check(Human, Object)
     */
    boolean check(Human findHuman, Object value);
}
