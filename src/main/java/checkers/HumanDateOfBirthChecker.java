package checkers;

import human.Human;

public class HumanDateOfBirthChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getDateOfBirth().equals(value);
    }
}
