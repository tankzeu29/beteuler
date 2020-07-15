package euler.factorial;

import java.math.BigInteger;

public class DivideAndConquerFactorialSupplier implements Factorial {
  @Override
  public BigInteger get(long number) {


    return multiplyInRange(1, number, 32);
  }

  public static BigInteger multiplyInRange(int split, long from, long to) {
    if (split < 1 || to - from < 2)
      return fastMultiply(from, to);
    split--;
    long middle = (from + to) >>> 1;
    return multiplyInRange(split, from, middle).multiply(multiplyInRange(split, middle, to));
  }

  private static BigInteger fastMultiply(long start, long end) {
    BigInteger bi = BigInteger.valueOf(start++);
    for (; start < end; start++) {
      bi = bi.multiply(BigInteger.valueOf(start));
    }
    return bi;
  }
}
