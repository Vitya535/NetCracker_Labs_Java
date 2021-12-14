package sorters;

import human.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * BubbleSorter Class for repository  {@link RepositoryForHumans}
 *
 * @author Kushnerenko Victor
 * @see Sorter
 * @see InsertSorter
 * @see ShellSorter
 */
public class BubbleSorter implements Sorter {

    /**
     * private object of class Logger for logging class BubbleSorter
     */
    private static final Logger logger = LogManager.getLogger(Sorter.class);

    /**
     * Function for bubblesort people in repository
     *
     * @param repository - repository, which we want to sort {@link RepositoryForHumans}
     * @param comparator - comparator, by which we want to sort people {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
        logger.debug("method sort invoke with params: " + repository.toString() + "and " + comparator);
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