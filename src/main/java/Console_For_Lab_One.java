import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Scanner;

/**
 * Консольное приложение для работы с обьектами класса Human
 * и репозиторием, в котором они содержатся
 * @author Кушнеренко Виктор
 * @version 1.1
 */
class Console_For_Lab_One
{
    /**
     * точка входа нашего приложения
     * @param args - аргументы командной строки
     */
    public static void main(String args[])
    {
        System.out.println("Добро пожаловать!");
        System.out.println("Команды, доступные для работы:");
        System.out.println("1 - Посмотреть команды");
        System.out.println("2 - Добавить в репозиторий человека");
        System.out.println("3 - Удалить из репозитория человека");
        System.out.println("4 - Получить всю информацию о человеке по индексу");
        System.out.println("5 - Выйти из приложения");
        Scanner scan = new Scanner(System.in);
        Repository_For_Humans repository = new Repository_For_Humans();
        while(true)
        {
            System.out.print("Введите номер команды, которую вы хотите выполнить: ");
            int number_of_command = scan.nextInt();
            switch(number_of_command)
            {
                case 1:
                    System.out.println("Команды, доступные для работы:");
                    System.out.println("1 - Посмотреть команды");
                    System.out.println("2 - Добавить в репозиторий человека");
                    System.out.println("3 - Удалить из репозитория человека");
                    System.out.println("4 - Получить всю информацию о человеке по индексу");
                    System.out.println("5 - Выйти из приложения");
                    break;
                case 2:
                    System.out.print("Введите фамилию человека: ");
                    String surname = scan.next();
                    System.out.print("Введите имя человека: ");
                    String name = scan.next();
                    System.out.print("Введите отчество человека: ");
                    String patronymic = scan.next();
                    System.out.print("Введите дату рождения человека: ");
                    DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
                    DateTime date_of_birth = formatter.parseDateTime(scan.next());
                    System.out.print("Введите пол человека (MALE - мужской, FEMALE - женский): ");
                    Sex sex = Sex.valueOf(scan.next());
                    Human new_human = new Human(surname, name, patronymic, date_of_birth, sex);
                    repository.Add(new_human);
                    break;
                case 3:
                    System.out.print("Введите позицию человека в репозитории (начиная с 1): ");
                    int index = scan.nextInt();
                    repository.RemoveAt(index - 1);
                    break;
                case 4:
                    System.out.print("Введите позицию человека в репозитории (начиная с 1): ");
                    int get_index = scan.nextInt();
                    String information = repository.Get(get_index - 1).toString();
                    System.out.println(information);
                    break;
                case 5:
                    return;
            }
        }
    }
}
