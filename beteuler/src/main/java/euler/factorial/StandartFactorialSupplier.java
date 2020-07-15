package euler.factorial;

import java.math.BigInteger;
import euler.MathUtils;

public class StandartFactorialSupplier implements Factorial {
  @Override
  public BigInteger get(long number) {

    return MathUtils.factorial(number);
  }
}
