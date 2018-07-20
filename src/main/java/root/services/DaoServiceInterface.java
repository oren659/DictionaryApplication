package root.services;

import java.util.List;

/**
 * Represents the Dao interface that any Data layer service will have to
 * implement in order to be used
 */
public interface DaoServiceInterface {
	List<String> getDictionaryPhrases();
}
