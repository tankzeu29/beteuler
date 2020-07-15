package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import euler.MathUtils;

public class MathUtilsTest {

  @Test
  public void testFactorialNormal() {

    assertEquals(BigInteger.ONE, MathUtils.factorial(0));
    assertEquals(BigInteger.ONE, MathUtils.factorial(1));
    assertEquals(BigInteger.valueOf(120), MathUtils.factorial(5));
  }

  @Test
  public void testFactorialParallel() {
    assertEquals(BigInteger.ONE, MathUtils.factorial(0));
    assertEquals(BigInteger.ONE, MathUtils.factorial(1));
    assertEquals(BigInteger.valueOf(120), MathUtils.factorial(5));
  }
}
