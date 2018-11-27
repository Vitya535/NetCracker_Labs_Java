package checkers;


import human.Human;

/**
 * Class for finding people in repository
 * on surname
 * @see Checker
 * @see HumanAgeChecker
 * @see HumanDateOfBirthChecker
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class HumanSurnameChecker implements Checker
{
    /**
     * Override method check for finding people in repository
     * on surname
     * @see Checker#check(Human, Object)
     * @see HumanAgeChecker#check(Human, Object)
     * @see HumanDateOfBirthChecker#check(Human, Object)
     * @param findHuman - human, who we find {@link Human}
     * @param value - value of some parameter, by which we find him
     * @return returns boolean value, which define is that human who we find or not
     */
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getSurname().equals(value);
    }
}
