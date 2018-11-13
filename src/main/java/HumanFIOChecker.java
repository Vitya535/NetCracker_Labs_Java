public class HumanFIOChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getFIO() == value;
    }
}
