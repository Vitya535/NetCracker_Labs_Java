package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * Класс сортировщика вставками для репозитория {@link RepositoryForHumans}
 * @see BubbleSorter
 * @see Sorter
 * @see ShellSorter
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class InsertSorter implements Sorter{

    /**
     * Функция сортировки вставками людей в репозитории
     * @param repository - репозиторий, который мы хотим отсортировать {@link RepositoryForHumans}
     * @param comparator - компаратор, по которому мы хотим сортировать людей {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     * @see ShellSorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
        for (int i = 1; i < repository.Count(); i++) {
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
