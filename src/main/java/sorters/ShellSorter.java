package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

public class ShellSorter implements Sorter {
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
