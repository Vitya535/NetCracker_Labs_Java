package sorters;

import human.Human;
import repository.RepositoryForHumans;

import java.util.Comparator;

public interface Sorter {
    void sort(RepositoryForHumans repository, Comparator<Human> comparator);
}
