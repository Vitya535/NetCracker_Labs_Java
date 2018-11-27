package sorters;
import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * BubbleSorter Class for repository  {@link RepositoryForHumans}
 * @see Sorter
 * @see InsertSorter
 * @see ShellSorter
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class BubbleSorter implements Sorter {

    /**
     * Function for bubblesort people in repository
     * @param repository - repository, which we want to sort {@link RepositoryForHumans}
     * @param comparator - comparator, by which we want to sort people {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
        for (int i = repository.count() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(repository.get(j), repository.get(j + 1)) > 0) {
                    Human tmp = repository.get(j);
                    repository.set(j, repository.get(j + 1));
                    repository.set(j + 1, tmp);
                }
            }
        }
    }
}