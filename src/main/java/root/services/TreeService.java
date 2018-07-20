package root.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.tree.DataStructureInterface;
import root.tree.Tree;

/**
 * This service implements the DataStructureServiceInterface using a Tree of Strings
 */

@Service
public class TreeService implements DataStructureServiceInterface {

	@Autowired
	private DaoServiceInterface daoService;

	private Tree tree;

	@PostConstruct
	private void init() {
		List<String> phrases = daoService.getDictionaryPhrases();
		tree = new Tree();

		for (String phrase : phrases) {
			tree.insert(phrase);
		}
		
	}
	public Tree getDataStructure() {
		return tree;
	}

}
