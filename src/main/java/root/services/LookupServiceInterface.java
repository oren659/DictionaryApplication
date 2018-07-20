package root.services;

import java.util.Map;

/**
 * The lookup service interface, handles the input received by the receiver
 */
public interface LookupServiceInterface {

	Map<String, Integer> proccessInput(String input);
}
