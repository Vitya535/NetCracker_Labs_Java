package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * Интерфейс сортировщика для репозитория {@link RepositoryForHumans}
 * @see BubbleSorter
 * @see InsertSorter
 * @see ShellSorter
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public interface Sorter {

    /**
     * Функция сортировки людей в репозитории
     * @param repository - репозиторий, который мы хотим отсортировать {@link RepositoryForHumans}
     * @param comparator - компаратор, по которому мы хотим сортировать людей {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see ShellSorter#sort(RepositoryForHumans, Comparator)
     */
    void sort(RepositoryForHumans repository, Comparator<Human> comparator);
}
