package checkers;

import human.Human;

public class HumanAgeChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return Integer.valueOf(findHuman.getAge()).equals(value);
    }
}
