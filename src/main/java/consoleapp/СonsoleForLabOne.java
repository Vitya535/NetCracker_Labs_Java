package consoleapp;

import comparers.HumanAgeComparator;
import comparers.HumanDateOfBirthComparator;
import comparers.HumanSurnameComparator;
import human.Gender;
import human.Human;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import repository.RepositoryForHumans;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Console application for work with objects of class human.Human
 * and repository, that contains them
 *
 * @author Kushnerenko Victor
 */
class ConsoleForLabOne {
    /**
     * private object of class Logger for logging class ConsoleForLabOne
     */
    private static final Logger logger = Logger.getLogger(ConsoleForLabOne.class);

    /**
     * entry point of application
     *
     * @param args - arguments of command line
     */
    public static void main(String[] args) {
        logger.debug("run console with args: " + Arrays.toString(args));
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
        logger.info("run infinite cycle for work with humans in repository");
        while (true) {
            System.out.print("Введите номер команды, которую вы хотите выполнить: ");
            int numberOfCommand = scan.nextInt();
            logger.info("check command, which we want to run: " + numberOfCommand);
            switch (numberOfCommand) {
                case 1:
                    logger.info("run command 1");
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
                    logger.info("run command 2");
                    System.out.print("Введите фамилию человека: ");
                    String surname = scan.next();
                    logger.info("entered surname of human: " + surname);
                    System.out.print("Введите имя человека: ");
                    String name = scan.next();
                    logger.info("entered name of human: " + name);
                    System.out.print("Введите отчество человека: ");
                    String patronymic = scan.next();
                    System.out.print("Введите дату рождения человека: ");
                    logger.info("entered patronymic of human: " + patronymic);
                    DateTime dateOfBirth = formatter.parseDateTime(scan.next());
                    logger.info("entered date of birth of human: " + dateOfBirth);
                    System.out.print("Введите пол человека (MALE - мужской, FEMALE - женский): ");
                    Gender gender = Gender.valueOf(scan.next());
                    logger.info("entered gender of human: " + gender);
                    Human newHuman = new Human(surname, name, patronymic, dateOfBirth, gender);
                    logger.info("add human in repository: " + newHuman.toString());
                    repository.add(newHuman);
                    break;
                case 3:
                    logger.info("run command 3");
                    System.out.print("Введите позицию человека в репозитории (начиная с 1): ");
                    int removeIndex = scan.nextInt();
                    logger.info("get index, by which we want to remove human: " + (removeIndex - 1));
                    try {
                        logger.info("remove human");
                        repository.removeAt(removeIndex - 1);
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }
                    logger.info("remove human");
                    break;
                case 4:
                    logger.info("run command 4");
                    System.out.print("Введите позицию человека в репозитории (начиная с 1): ");
                    int getIndex = scan.nextInt();
                    logger.info("get index, by which we want to get human: " + (getIndex - 1));
                    logger.info("get info about this human");
                    String information = repository.get(getIndex - 1).toString();
                    System.out.println(information);
                    break;
                case 5:
                    logger.info("run command 5");
                    System.out.print("Введите значение по которому вы хотите найти людей (1 - Фамилия, 2 - Дата рождения, 3 - Возраст): ");
                    int searchIndex = scan.nextInt();
                    logger.info("get search index, by which we want to find people: " + searchIndex);
                    switch (searchIndex) {
                        case 1:
                            logger.info("find on surname");
                            System.out.print("Введите фамилию: ");
                            String findSurname = scan.next();
                            logger.info("entered surname: " + findSurname);
                            System.out.println(repository.findOn(findSurname).toString());
                            break;
                        case 2:
                            logger.info("find on date of birth");
                            System.out.print("Введите дату рождения: ");
                            DateTime findDateOfBirth = formatter.parseDateTime(scan.next());
                            logger.info("entered date of birth: " + findDateOfBirth);
                            System.out.println(repository.findOn(findDateOfBirth).toString());
                            break;
                        case 3:
                            logger.info("find on age");
                            System.out.print("Введите возраст: ");
                            int findAge = scan.nextInt();
                            logger.info("entered age: " + findAge);
                            System.out.println(repository.findOn(findAge).toString());
                            break;
                    }
                    break;
                case 6:
                    logger.info("run command 6");
                    System.out.print("Введите значение по которому вы хотите отсортировать людей (1 - Фамилия, 2 - Дата рождения, 3 - Возраст): ");
                    int sortIndex = scan.nextInt();
                    logger.info("get sort index, by which we want to sort people: " + sortIndex);
                    switch (sortIndex) {
                        case 1:
                            logger.info("sort on surname");
                            System.out.println(repository.toString());
                            repository.sortBy(new HumanSurnameComparator());
                            System.out.println(repository.toString());
                            break;
                        case 2:
                            logger.info("sort on date of birth");
                            System.out.println(repository.toString());
                            repository.sortBy(new HumanDateOfBirthComparator());
                            System.out.println(repository.toString());
                            break;
                        case 3:
                            logger.info("sort on age");
                            System.out.println(repository.toString());
                            repository.sortBy(new HumanAgeComparator());
                            System.out.println(repository.toString());
                            break;
                    }
                    break;
                case 7:
                    logger.info("run command 7");
                    logger.info("close the application");
                    return;
            }
        }
    }
}
