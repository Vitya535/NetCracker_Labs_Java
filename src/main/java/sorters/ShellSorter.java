package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * Класс сортировщика Шелла для репозитория {@link RepositoryForHumans}
 * @see BubbleSorter
 * @see InsertSorter
 * @see Sorter
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class ShellSorter implements Sorter {

    /**
     * Функция сортировки Шелла людей в репозитории
     * @param repository - репозиторий, который мы хотим отсортировать {@link RepositoryForHumans}
     * @param comparator - компаратор, по которому мы хотим сортировать людей {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
        int step = 5;
        while (step > 0) {
            int j;
            for (int i = step; i < repository.Count(); i++) {
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
