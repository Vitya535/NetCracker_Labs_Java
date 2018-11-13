public class HumanPatronymicChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getPatronymic() == value;
    }
}
