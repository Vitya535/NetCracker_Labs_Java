package sorters;

import human.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * ShellSorter Class for repository {@link RepositoryForHumans}
 *
 * @author Kushnerenko Victor
 * @see BubbleSorter
 * @see InsertSorter
 * @see Sorter
 */
public class ShellSorter implements Sorter {

    /**
     * private object of class Logger for logging class ShellSorter
     */
    private static final Logger logger = LogManager.getLogger(Sorter.class);

    /**
     * Function for shellsort people in repository
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
        int step = 5;
        while (step > 0) {
            int j;
            for (int i = step; i < repository.count(); i++) {
                Human human = repository.get(i);
                for (j = i - step; j >= 0 && comparator.compare(repository.get(j), human) >= 0; j -= step) {
                    repository.set(j + step, repository.get(j));
                }
                repository.set(j + step, human);
            }
            step -= 2;
        }
    }
}
