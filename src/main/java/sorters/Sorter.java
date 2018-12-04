package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * Interface of sorter for repository {@link RepositoryForHumans}
 *
 * @author Kushnerenko Victor
 * @see BubbleSorter
 * @see InsertSorter
 * @see ShellSorter
 */
public interface Sorter {

    /**
     * Function for sort people in repository
     *
     * @param repository - repository, which we want to sort {@link RepositoryForHumans}
     * @param comparator - comparator, by which we want to sort people {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see ShellSorter#sort(RepositoryForHumans, Comparator)
     */
    void sort(RepositoryForHumans repository, Comparator<Human> comparator);
}
