package sorters;

import human.Human;
import org.apache.log4j.Logger;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * InsertSorter class for repository {@link RepositoryForHumans}
 * @see BubbleSorter
 * @see Sorter
 * @see ShellSorter
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class InsertSorter implements Sorter{

    /** private object of class Logger for logging class InsertSorter*/
    private static final Logger logger = Logger.getLogger(Sorter.class);

    /**
     * InsertSort Function for sort repository of people
     * @param repository - repository, which we want to sort {@link RepositoryForHumans}
     * @param comparator - comparator, by which we want to sort people {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     * @see ShellSorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
        logger.debug("method sort invoke with params: " + repository.toString() + "and " + comparator);
        for (int i = 1; i < repository.count(); i++) {
            int j;
            Human buf = repository.get(i);
            for (j = i - 1; j >= 0; j--) {
                if (comparator.compare(repository.get(j),buf) < 0) {
                    break;
                }
                repository.set(j + 1, repository.get(j));
            }
            repository.set(j + 1, buf);
        }
    }
}
