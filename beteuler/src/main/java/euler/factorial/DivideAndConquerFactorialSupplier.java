package euler.factorial;

import java.math.BigInteger;

/**
 * Divide and conquer factorial strategy
 * 
 * @author Tankz
 *
 */
public class DivideAndConquerFactorialSupplier implements Factorial {

  /**
   * Retrieves factorial value
   * 
   * @param factorialIndex - factorial index
   * @return factorial value
   */
  @Override
  public BigInteger get(long factorialIndex) {


    return multiplyInRange(1, factorialIndex, 32);
  }

  /**
   * Divides the computation of factorial into a tree and computes until there are adjacent
   * facotrials
   * 
   * @param split - tree height
   * @param from - start factorial index
   * @param to - end factorial index
   * @return factorial value
   */
  public static BigInteger multiplyInRange(int split, long from, long to) {
    if (split < 1 || to - from < 2)
      return fastMultiply(from, to);
    split--;
    long middle = (from + to) >>> 1;
    return multiplyInRange(split, from, middle).multiply(multiplyInRange(split, middle, to));
  }

  /**
   * Multiplies values in a range [start;end)
   * 
   * @param start - start value to multiply
   * @param end - end value to multiply
   * @return the result of multiplying all numbers in range [start;end)
   */
  private static BigInteger fastMultiply(long start, long end) {
    BigInteger bi = BigInteger.valueOf(start++);
    for (; start < end; start++) {
      bi = bi.multiply(BigInteger.valueOf(start));
    }
    return bi;
  }
}
