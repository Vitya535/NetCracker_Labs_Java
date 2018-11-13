public class Utils {
    public static void bubbleSort(RepositoryForHumans repository) {
        for (int i = repository.Count() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (repository.get(j).compareTo(repository.get(j + 1)) > 0)
                {
                    Human tmp = repository.get(j);
                    repository.set(j, repository.get(j + 1));
                    repository.set(j + 1, tmp);
                }
            }
        }
    }

    public static void insertSortWithSerialFind(RepositoryForHumans repository) {
        for (int i = 1; i < repository.Count(); i++) {
            int j;
            Human buf = repository.get(i);
            for (j = i - 1; j >= 0; j--) {
                if (repository.get(j).compareTo(buf) < 0) {
                    break;
                }
                repository.set(j + 1, repository.get(j));
            }
            repository.set(j + 1, buf);
        }
    }

    public static void shellSort(RepositoryForHumans repository) {
        int step = 5;
        while (step > 0) {
            int j;
            for (int i = step; i < repository.Count(); i++) {
                Human human = repository.get(i);
                for (j = i - step; j >= 0 && repository.get(j).compareTo(human) >= 0; j -= step) {
                    repository.set(j + step, repository.get(j));
                }
                repository.set(j + step, human);
            }
            step -= 2;
        }
    }
}
