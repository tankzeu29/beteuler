package app.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Used to log information about the game
 */
public class ApplicationLogger {

  private static Handler fileHandler = null;
  private static final String LOG_FILE = "./server-log.txt";
  private static final Logger LOGGER =
      Logger.getLogger(ApplicationLogger.class.getClass().getName());

  /**
   * initializes the logger
   */
  public static void setup() {

    try {
      fileHandler = new FileHandler(LOG_FILE);
      SimpleFormatter simpleFormater = new SimpleFormatter();
      fileHandler.setFormatter(simpleFormater);

      LOGGER.addHandler(fileHandler);

    } catch (IOException e) {
      System.out.println("Failed to initialize logger");
      System.out.println(e.getMessage());
    }

  }

  /**
   * Retrieves singleton instance of the logger
   * 
   * @return application logger
   */
  public static Logger getLogger() {
    return LOGGER;
  }
}
