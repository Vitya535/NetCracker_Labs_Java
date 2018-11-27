package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * ShellSorter Class for repository {@link RepositoryForHumans}
 * @see BubbleSorter
 * @see InsertSorter
 * @see Sorter
 * @author Kushnerenko Victor
 * @version 1.2
 */
public class ShellSorter implements Sorter {

    /**
     * Function for shellsort people in repository
     * @param repository - repository, which we want to sort {@link RepositoryForHumans}
     * @param comparator - comparator, by which we want to sort people {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
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
