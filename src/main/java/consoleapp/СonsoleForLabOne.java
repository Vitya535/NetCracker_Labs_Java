package consoleapp;

import comparers.HumanAgeComparator;
import comparers.HumanDateOfBirthComparator;
import comparers.HumanSurnameComparator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import human.Human;
import human.Sex;
import repository.RepositoryForHumans;

import java.util.Scanner;

/**
 * Консольное приложение для работы с обьектами класса human.Human
 * и репозиторием, в котором они содержатся
 * @author Кушнеренко Виктор
 * @version 1.2
 */
class ConsoleForLabOne
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
        System.out.println("5 - Поиск человека по определенному параметру");
        System.out.println("6 - Сортировка людей по определенному параметру");
        System.out.println("7 - Выйти из приложения");
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        RepositoryForHumans repository = new RepositoryForHumans();
        while(true)
        {
            System.out.print("Введите номер команды, которую вы хотите выполнить: ");
            int numberOfCommand = scan.nextInt();
            switch(numberOfCommand)
            {
                case 1:
                    System.out.println("Команды, доступные для работы:");
                    System.out.println("1 - Посмотреть команды");
                    System.out.println("2 - Добавить в репозиторий человека");
                    System.out.println("3 - Удалить из репозитория человека");
                    System.out.println("4 - Получить всю информацию о человеке по индексу");
                    System.out.println("5 - Поиск человека по определенному параметру");
                    System.out.println("6 - Сортировка людей по определенному параметру");
                    System.out.println("7 - Выйти из приложения");
                    break;
                case 2:
                    System.out.print("Введите фамилию человека: ");
                    String surname = scan.next();
                    System.out.print("Введите имя человека: ");
                    String name = scan.next();
                    System.out.print("Введите отчество человека: ");
                    String patronymic = scan.next();
                    System.out.print("Введите дату рождения человека: ");
                    DateTime dateOfBirth = formatter.parseDateTime(scan.next());
                    System.out.print("Введите пол человека (MALE - мужской, FEMALE - женский): ");
                    Sex sex = Sex.valueOf(scan.next());
                    Human newHuman = new Human(surname, name, patronymic, dateOfBirth, sex);
                    repository.add(newHuman);
                    break;
                case 3:
                    System.out.print("Введите позицию человека в репозитории (начиная с 1): ");
                    int removeIndex = scan.nextInt();
                    repository.removeAt(removeIndex - 1);
                    break;
                case 4:
                    System.out.print("Введите позицию человека в репозитории (начиная с 1): ");
                    int getIndex = scan.nextInt();
                    String information = repository.get(getIndex - 1).toString();
                    System.out.println(information);
                    break;
                case 5:
                    System.out.print("Введите значение по которому вы хотите найти людей (1 - Фамилия, 2 - Дата рождения, 3 - Возраст): ");
                    int searchIndex = scan.nextInt();
                    switch(searchIndex)
                    {
                        case 1:
                            System.out.print("Введите фамилию: ");
                            String findSurname = scan.next();
                            System.out.println(repository.findOn(findSurname).toString());
                            break;
                        case 2:
                            System.out.print("Введите дату рождения: ");
                            DateTime findDateOfBirth = formatter.parseDateTime(scan.next());
                            System.out.println(repository.findOn(findDateOfBirth).toString());
                            break;
                        case 3:
                            System.out.print("Введите возраст: ");
                            int findAge = scan.nextInt();
                            System.out.println(repository.findOn(findAge).toString());
                            break;
                    }
                    break;
                case 6:
                    System.out.print("Введите значение по которому вы хотите отсортировать людей (1 - Фамилия, 2 - Дата рождения, 3 - Возраст): ");
                    int sortIndex = scan.nextInt();
                    switch (sortIndex)
                    {
                        case 1:
                            System.out.println(repository.toString());
                            repository.sortBy(new HumanSurnameComparator());
                            System.out.println(repository.toString());
                            break;
                        case 2:
                            System.out.println(repository.toString());
                            repository.sortBy(new HumanDateOfBirthComparator());
                            System.out.println(repository.toString());
                            break;
                        case 3:
                            System.out.println(repository.toString());
                            repository.sortBy(new HumanAgeComparator());
                            System.out.println(repository.toString());
                            break;
                    }
                    break;
                case 7:
                    return;
            }
        }
    }
}
