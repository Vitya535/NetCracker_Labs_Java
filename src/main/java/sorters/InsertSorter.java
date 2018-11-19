package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

public class InsertSorter implements Sorter{
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
