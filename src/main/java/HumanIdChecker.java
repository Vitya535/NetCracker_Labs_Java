public class HumanIdChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return Integer.valueOf(findHuman.getId()) == value;
    }
}
