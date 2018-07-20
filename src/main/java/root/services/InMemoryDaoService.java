package root.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * This service represents an implementation of a data layer service, currently
 * it is implemented in memory but it can be also read from a DB or other data
 * source.
 */
@Service
public class InMemoryDaoService implements DaoServiceInterface {

	private static Logger logger = LogManager.getLogger(InMemoryDaoService.class);

	private List<String> dictionaryPhrases = new LinkedList<>();

	public InMemoryDaoService() {

		logger.info("Loading the phrases into the memory");

		dictionaryPhrases.add("President");
		dictionaryPhrases.add("Vice President");
		dictionaryPhrases.add("Sales");
		dictionaryPhrases.add("Marketing");
		dictionaryPhrases.add("IT");
		dictionaryPhrases.add("CFO");
		dictionaryPhrases.add("CTO");
		dictionaryPhrases.add("Banking");
		dictionaryPhrases.add("eComerce");
		dictionaryPhrases.add("dog");
		dictionaryPhrases.add("dog wolf tiger");
		dictionaryPhrases.add("mom");
		dictionaryPhrases.add("mom dad john ron");
		dictionaryPhrases.add("Boy");
		dictionaryPhrases.add("u2 counting crows cranberries");
		dictionaryPhrases.add("counting crows");
		dictionaryPhrases.add("Banking CFO CfO ron");

		logger.info(dictionaryPhrases.size() + " phrases were loaded the phrases into the memory");

	}

	public List<String> getDictionaryPhrases() {
		return dictionaryPhrases.stream().collect(Collectors.toList());
	}
}
