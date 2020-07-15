package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.Level;
import org.junit.jupiter.api.Test;
import app.logging.ApplicationLogger;
import euler.strategy.AbstractStrategy;

/**
 * Base class to start all the tests
 * 
 * @author Tankz
 *
 */
public class BaseStrategyTests {
  private Supplier<AbstractStrategy> strategy;

  /**
   * Retrieves strategy
   * 
   * @return strategy to compute
   */
  public Supplier<AbstractStrategy> getStrategy() {
    return strategy;
  }

  /**
   * Sets strategy to compute result
   * 
   * @param strategy - strategy to compute
   */
  public void setStrategy(Supplier<AbstractStrategy> strategy) {
    this.strategy = strategy;
  }

  /**
   * Initialize test strategy
   * 
   * @param strategy - stategy to be used
   */
  BaseStrategyTests(Supplier<AbstractStrategy> strategy) {
    this.strategy = strategy;
  }

  /**
   * Tests if the first 2 digits are correct
   * 
   */
  @Test
  public void testENumber2Digits() {
    BigDecimal eNumber = strategy.get().computeEulerNumber(2);

    assertEquals(TestConstants.EULER_NUMBER_FIRST_THREE_DIGITS, eNumber.toString(),
        "First three digits of the euler number are not correct");
  }

  /**
   * Tests if the first 100 digits are correct -
   */
  @Test
  public void testEnumber100Digits() {
    BigDecimal eulerNumber = strategy.get().computeEulerNumber(100);

    String loadedTestFile = loadTestFileAsString(TestConstants.HUNDRED_DIGITS_TEST_FILE);
    assertEquals(loadedTestFile, convertEulerNumberToString(eulerNumber),
        "First 100 digits of the euler number are not correct");
  }

  /**
   * Tests if the first 1000 digits are correct
   * 
   */
  @Test
  public void testEnumber1000Digits() {
    BigDecimal eulerNumber = strategy.get().computeEulerNumber(1000);
    String loadedTestFile = loadTestFileAsString(TestConstants.THOUSAND_DIGITS_TEST_FILE);
    assertEquals(loadedTestFile, convertEulerNumberToString(eulerNumber),
        "First 1000 digits of the euler number are not correct");

  }

  /**
   * Tests if the first 10000 digits are correct
   * 
   */
  @Test
  public void testEnumber10000Digits() {
    BigDecimal eulerNumber = strategy.get().computeEulerNumber(10000);

    String loadedTestFile = loadTestFileAsString(TestConstants.TEN_THOUSAND_DIGITS_TEST_FILE);
    assertEquals(loadedTestFile, convertEulerNumberToString(eulerNumber),
        "First 10,000 of the euler number are not correct");
  }

  /**
   * Loads file to compare the test resuelt
   * 
   * @param path - path to test file containing Euler number result
   * @return file containing the euler number
   */
  private String loadTestFileAsString(String path) {

    File testFile = new File(Paths.get(".").toAbsolutePath().normalize().toString() + File.separator
        + TestConstants.TEST_FILES_DIRECTORY + File.separator + path);

    String content = null;
    try {
      content = new String(Files.readAllBytes(Paths.get(testFile.getAbsolutePath())),
          StandardCharsets.UTF_8);
    } catch (IOException e) {
      ApplicationLogger.getLogger().log(Level.SEVERE,
          "Failed to load testFile " + testFile.getAbsolutePath(), e);
    }
    return content;


  }

  /**
   * Converts euler number from decimal to String
   * 
   * @param eulerNumber - euler number to be converted to String
   * @return euler number as a String
   */
  private String convertEulerNumberToString(BigDecimal eulerNumber) {



    return eulerNumber.toString();

  }
}
