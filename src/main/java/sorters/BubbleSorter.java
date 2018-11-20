package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

/**
 * Класс пузырькового сортировщика для репозитория {@link RepositoryForHumans}
 * @see Sorter
 * @see InsertSorter
 * @see ShellSorter
 * @author Кушнеренко Виктор
 * @version 1.2
 */
public class BubbleSorter implements Sorter {

    /**
     * Функция пузырьковой сортировки людей в репозитории
     * @param repository - репозиторий, который мы хотим отсортировать {@link RepositoryForHumans}
     * @param comparator - компаратор, по которому мы хотим сортировать людей {@link Comparator}
     * @see BubbleSorter#sort(RepositoryForHumans, Comparator)
     * @see InsertSorter#sort(RepositoryForHumans, Comparator)
     * @see Sorter#sort(RepositoryForHumans, Comparator)
     */
    @Override
    public void sort(RepositoryForHumans repository, Comparator<Human> comparator) {
        for (int i = repository.Count() - 1; i > 0; i--) {
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