public class HumanSexChecker implements Checker
{
    @Override
    public boolean check(Human findHuman, Object value) {
        return findHuman.getSex() == value;
    }
}
