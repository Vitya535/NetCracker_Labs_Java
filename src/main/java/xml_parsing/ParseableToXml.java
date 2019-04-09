package xml_parsing;

import repository.RepositoryForHumans;

public interface ParseableToXml {
    String convertStudentsToXml(RepositoryForHumans repository) throws Exception;
}
