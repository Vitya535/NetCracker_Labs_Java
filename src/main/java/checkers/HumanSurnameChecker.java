package checkers;


import human.Human;

public class HumanSurnameChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getSurname().equals(value);
    }
}
