package xml_parsing;

import repository.RepositoryForHumans;

public interface ParseableFromXml {
    RepositoryForHumans parse(String filename) throws Exception;
}
