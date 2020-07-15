package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import euler.MathUtils;

/**
 * Test for math utils
 * 
 * @author Tankz
 *
 */
public class MathUtilsTest {

  /**
   * Tests factorial in parallel mode
   */

  @Test
  public void testFactorialParallel() {
    assertEquals(BigInteger.ONE, MathUtils.factorial(0));
    assertEquals(BigInteger.ONE, MathUtils.factorial(1));
    assertEquals(BigInteger.valueOf(120), MathUtils.factorial(5));
  }
}
