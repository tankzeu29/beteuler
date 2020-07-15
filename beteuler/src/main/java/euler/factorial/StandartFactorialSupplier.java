package euler.factorial;

import java.math.BigInteger;
import euler.MathUtils;

/**
 * Factorial supplier using parallel streams
 * 
 * @author Tankz
 *
 */
public class StandartFactorialSupplier implements Factorial {
  /**
   * Retrieve the factorial using parallel streams
   * 
   * @param number - number to retrieve factorial
   * @return factorial value
   */
  @Override
  public BigInteger get(long number) {

    return MathUtils.factorial(number);
  }
}
