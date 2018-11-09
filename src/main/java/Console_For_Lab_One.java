import org.joda.time.DateTime;

/**
 * Консольное приложение для работы с обьектами класса Human
 * и репозиторием, в котором они содержатся
 * @author Кушнеренко Виктор
 * @version 1.0
 */
class Console_For_Lab_One
{
    /**
     * точка входа нашего приложения
     * @param args - аргументы командной строки
     */
    public static void main(String args[])
    {
        System.out.println("Hello World");
        DateTime time = new DateTime(1998, 3, 12, 0, 0);
        Human test_human = new Human(1, "Кушнеренко", "Виктор", "Константинович", time);
        Repository_For_Humans repository = new Repository_For_Humans(new Human[]{test_human});
        System.out.println(test_human.getAge());
        System.out.println(test_human.getFIO());
        System.out.println(test_human.getDate_of_birth().getMonthOfYear());
        System.out.println(test_human.getAge());
        System.out.println(test_human);
        System.out.println(repository);
        Human test_human_2 = new Human(2, "Кушнеренко", "Виктор", "Константинович", time);
        repository.Add(test_human_2);
        System.out.println(repository);
        repository.Delete();
        System.out.println(repository);
    }
}
