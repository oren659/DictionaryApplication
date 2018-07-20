package root.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.services.LookupServiceInterface;

/**
 * This controller receive the HTTP REST request, and pass it's path variable to
 * the LookupService for handling
 */
@RestController
public class RecieverController {

	private static Logger logger = LogManager.getLogger(RecieverController.class);

	final static String PHRASE_PATH_VARIABLE = "phrase";
	final static String CATEGORIZE_PATH_VARIABLE = "/categorize";
	@Autowired
	private LookupServiceInterface lookupService;

	/**
	 * Accepts only GET requests, pass the path variable to the lookupService for
	 * handling and get back a Map with the results.
	 * 
	 * @param input
	 *            string- the value in the "phrase" path variable that we want to
	 *            parse and process.
	 * @return Map with the results
	 * @throws Exception
	 */
	@RequestMapping(value = CATEGORIZE_PATH_VARIABLE, method = RequestMethod.GET)
	public Map<String, Integer> handleMessage(@RequestParam(PHRASE_PATH_VARIABLE) String input) throws Exception {

		logger.debug("Input recieved: " + input);
		Map<String, Integer> resultsMap = lookupService.proccessInput(input);

		// the map will implicitly get converted to a Json, in real life scenario we
		// might consider using explicit conversion and provide the caller additional information
		return resultsMap;
	}

	/**
	 * This is a very minimal error handling\input validation, we might consider
	 * extended validation here
	 * 
	 */
	@ExceptionHandler({ Exception.class })
	public void handleException(Exception e) {
		logger.debug("An error occured while handing a request: " + e.getMessage());
	}

}
