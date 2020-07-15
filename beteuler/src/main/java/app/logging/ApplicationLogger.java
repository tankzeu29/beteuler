package app.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ApplicationLogger {

  private static Handler fileHandler = null;
  private static final String LOG_FILE = "./server-log.txt";
  private static final Logger LOGGER =
      Logger.getLogger(ApplicationLogger.class.getClass().getName());

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

  public static Logger getLogger() {
    return LOGGER;
  }
}
