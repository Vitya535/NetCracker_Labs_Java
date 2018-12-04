# NetCracker_Labs_Java
# Лабораторная работа 1:
# Суть задания:
Создать класс, который будет ассоциироваться с человеком. У этой сущности будут какие-то поля: ID, ФИО, Дата рождения, Пол. Сделать так, чтобы у этого человека можно было узнать возраст (на основе даты рождения).
Определить какой тип использовать под дату.
Как только с з-тями будет в порядке, можно отрефакторить с LocalData.
Создать некий репозиторий (класс) для хранения списка людей - добавление, извлечение, удаление. (не используем стандартные коллекции от Java)
Реализовать private поле в виде массива людей, сделать так чтобы этот массив расширялся.
Написать консольное приложение, которое позволяет поработать с этими классами.
Написать Unit тесты для всего этого. (в будущем)

# Лабораторная работа 2:
# Суть задания:
Добавить поддержку поиска и сортировки в репозиторий.
Как это сделать - дать возможность  искать по фамилии, дате рождения, возрасту и т. д.
То же самое с сортировкой.
Хотелось чтобы в репозитории была в-ть указать при помощи какого алгоритма мы будем сортировать (взять простые сортировки штуки 3).
Когда мы создаем репозиторий через конструктор, инициализирующий метод - указать способ сортировки.
Использовать интерфейсы.
Поиск: пройти и сравнить по какому-то критерию. В обход передать логику сравнения (критерий по которому будем сравнивать)
интерфейс - метод check (с проверкой, передается человек и обьект по которому нужно проверить, удовлетворяет ли человек этому обьекту)
будет некий абстрактный метод, осуществ. поиск по некоторым правилам (в него передается чекер).
имплементим класс в PersonFIOChecker, дата рождения и т. д.
3 метода сортировки, 3 компаратора
на сравнение больше/меньше - используется компаратор
1 больше 2 - 1
наоборот - -1
равны - 0
можно исп-ть стандартный Java интерфейс компаратора.

Писать Unit-тесты для задач.

интерфейс Sorter (массив людей, компаратор)
от этого интерфейса - 3 класса с сортировками
в классе поле Sorter
в репозитории - либо в конструкторе, либо в некотором методе - задавать сортировку
метод sortby - принимает компаратор, делегировать сортировку сортировщику

# Лабораторная работа 3:
# Суть задания:
Сделать логирование:
взять фреймворк log4j (либо любой другой)

Что такое логирование и зачем оно нужно?
Чтобы всегда была возможность узнать что происходило в системе до возникновения ошибки (сохранение информации о ходе выполнения программы)
фреймворки позволяют сохранять куда-либо информацию, которая может понадобиться
уровень значимости, уровень логирования информации
в логерах есть возможность определять к какому уровню относится то или иное сообщение
на различных этапах может понадобиться различная информация
Логируется система достаточно подробно
В соответствии с логикой раскидываем сообщения с определенным уровнем важности
Может быть синхронным/асинхронным (в зависимости от ситуации)
Аппендер (текстовые, HTML, для почты и т. д.) - добавляет информацию в лог
Определить один или несколько аппендеров
Тот или иной логгер использует один или несколько аппендеров
Соблюдать уровни логирования

# Лабораторная работа 4:
# Суть задания:
С помощью рефлексии реализовать иньекцию зависимостей.

Dependency Injection
Смысл заключается в том, чтобы как можно сильнее ослабить связь между классами.

Создать аннотацию Inject
@Retention - обязательно ставить
@Target - указать

Пометить аннотацией сортировщик (он будет попадать через иньекцию зависимостей)

Написать класс иньектор - 1 метод - принимает любой обьект и осуществляет иньекцию полей в этот обьект (где аннотация - туда запихнуть обьект)

Config.properties - чтобы иньектор разобрался какие поля инджектить
создавать обьекты репозитория - через инджектор (если через него не прогоним - то эти поля будут null)