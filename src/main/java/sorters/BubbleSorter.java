package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
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