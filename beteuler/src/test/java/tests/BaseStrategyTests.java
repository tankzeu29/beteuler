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


public class BaseStrategyTests {
  private Supplier<AbstractStrategy> strategy;

  public Supplier<AbstractStrategy> getStrategy() {
    return strategy;
  }

  public void setStrategy(Supplier<AbstractStrategy> strategy) {
    this.strategy = strategy;
  }

  BaseStrategyTests(Supplier<AbstractStrategy> strategy) {
    this.strategy = strategy;
  }

  @Test
  public void testENumber2Digits() throws Exception {
    BigDecimal eNumber = strategy.get().computeEulerNumber(2);

    assertEquals(TestConstants.EULER_NUMBER_FIRST_THREE_DIGITS, eNumber.toString(),
        "First three digits of the euler number are not correct");
  }

  @Test
  public void testEnumber100Digits() throws Exception {
    BigDecimal eulerNumber = strategy.get().computeEulerNumber(100);

    String loadedTestFile = loadTestFileAsString(TestConstants.HUNDRED_DIGITS_TEST_FILE);
    assertEquals(loadedTestFile, convertEulerNumberToString(eulerNumber),
        "First 100 digits of the euler number are not correct");
  }

  @Test
  public void testEnumber1000Digits() throws Exception {
    BigDecimal eulerNumber = strategy.get().computeEulerNumber(1000);
    String loadedTestFile = loadTestFileAsString(TestConstants.THOUSAND_DIGITS_TEST_FILE);
    assertEquals(loadedTestFile, convertEulerNumberToString(eulerNumber),
        "First 1000 digits of the euler number are not correct");

  }

  @Test
  public void testEnumber10000Digits() throws Exception {
    BigDecimal eulerNumber = strategy.get().computeEulerNumber(10000);

    String loadedTestFile = loadTestFileAsString(TestConstants.TEN_THOUSAND_DIGITS_TEST_FILE);
    assertEquals(loadedTestFile, convertEulerNumberToString(eulerNumber),
        "First 10,000 of the euler number are not correct");
  }

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

  private String convertEulerNumberToString(BigDecimal eulerNumber) {



    return eulerNumber.toString();

  }
}
