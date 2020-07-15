package euler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import app.logging.ApplicationLogger;

public class EulerFileWriter {

  public static boolean writeToFile(BigDecimal eulerNumber, String path) {
    try (FileWriter fileWriter = new FileWriter(new File(path))) {
      fileWriter.write(eulerNumber.toPlainString());
    } catch (IOException e) {
      ApplicationLogger.getLogger().log(Level.SEVERE, "Failed to save the result to file", e);
      return false;
    }

    return true;
  }

}
