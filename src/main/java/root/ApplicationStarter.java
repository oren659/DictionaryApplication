package root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The starting point of the Dictionary Spring Boot application
 */
@SpringBootApplication
public class ApplicationStarter {

	private static Logger logger = LogManager.getLogger(ApplicationStarter.class);

	public static void main(String[] args) {

		logger.info("################### Dictionary application started ###################");
		SpringApplication.run(ApplicationStarter.class, args);
	}

}
