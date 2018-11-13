public class HumanNameChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getName() == value;
    }
}
