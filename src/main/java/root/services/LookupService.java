package root.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.tree.Tree;

/**
 * This service receive the input from the controller and process it by sending
 * it chunk by chunk to the Tree service.
 */

@Service
public class LookupService implements LookupServiceInterface {

	@Autowired
	private DataStructureServiceInterface treeBuilderService;
	private static final String SPACE_STRING = " ";
	private static final String EMPTY_STRING = "";
	private Tree tree;

	/**
	 * Accepts only GET requests, pass the path variable to the lookupService for
	 * handling and get back a Map with the results.
	 * 
	 * @param input
	 *            the value received by the receiver.
	 * @return Map with the results, the results map is being prepared by calling
	 *         implicitly get converted to a Json, in real life scenario we would
	 *         consider using explicit conversion.
	 */
	public Map<String, Integer> proccessInput(String input) {

		Map<String, Integer> results = new HashMap<>();
		tree = treeBuilderService.getDataStructure();

		int location = 0;
		int originalInputSize = input.length();
		int nextSpace;

		while (input.length() > 0) {
			final String phraseFound = tree.search(input).trim();
			if (phraseFound.length() > 0) {
				results.put(phraseFound, location);
				location = location + phraseFound.length() + 1;
				if (originalInputSize > location) {
					input = input.substring(phraseFound.length() + 1);
				} else {
					input = EMPTY_STRING;
				}
			} else {
				nextSpace = input.indexOf(SPACE_STRING);
				if (nextSpace == -1) {
					input = EMPTY_STRING;
				} else {
					location = location + nextSpace + 1;
					if (originalInputSize > location) {
						input = input.substring(nextSpace + 1);
					} else {
						input = EMPTY_STRING;
					}
				}
			}

		}

		return results;
	}

}
