package euler.factorial;

import java.math.BigInteger;

/**
 * Interface implemented by all factorial computators
 * 
 * @author Tankz
 *
 */
public interface Factorial {
  /**
   * Retreives the factorial for particular number
   * 
   * @param number - factorial number
   * @return factorial value
   */
  BigInteger get(long number);
}
