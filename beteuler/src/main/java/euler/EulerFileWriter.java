package euler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import app.logging.ApplicationLogger;

/**
 * Writes the result from computation of Euler number to a file
 * 
 *
 * 
 */
public class EulerFileWriter {

  /**
   * Writes the result from Euler computation to a file
   * 
   * @param eulerNumber - computed Euler number
   * @param outputFilePath - file where the Euler number is stored
   * @return true if the writing was success , else false
   */
  public static boolean writeToFile(BigDecimal eulerNumber, String outputFilePath) {
    try (FileWriter fileWriter = new FileWriter(new File(outputFilePath))) {
      fileWriter.write(eulerNumber.toPlainString());
    } catch (IOException e) {
      ApplicationLogger.getLogger().log(Level.SEVERE, "Failed to save the result to file", e);
      return false;
    }

    return true;
  }

}
