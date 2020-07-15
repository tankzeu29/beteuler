package euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.stream.LongStream;
import euler.strategy.LambertW;

/*
 * Computes mathematical expressions
 */
public class MathUtils {

  private final static double EULER_NUMBER_MAIN_VALUE = 2.71;
  private final static int START_RANGE = 2;

  /**
   * Computes factorial with parallel streams
   * 
   * @param factorialIndex - factorial number to be computed
   * @return computed factorial
   */
  public static BigInteger factorial(final long factorialIndex) {
    return LongStream.range(START_RANGE, factorialIndex + 1).mapToObj(BigInteger::valueOf)
        .reduce(BigInteger.ONE, (current, factSoFar) -> factSoFar.multiply(current));
  }

  /**
   * Returns the total iterations to be executed
   * 
   * @param precision -precision for computation of Euler number
   * @return aproximate iterations to be executed
   */
  public static int calculateIterations(int precision) {
    return aprox(precision) + 1;

  }

  /**
   * Find the approximate iterations for given precision
   * 
   * @param precision - precision for computation of Euler number
   * @return
   */
  protected static int aprox(final int precision) {
    double startFraction = precision * Math.log(10);

    BigDecimal endFraction =
        BigDecimal.valueOf(4).multiply(new BigDecimal(Math.sqrt(Math.PI))).setScale(1000);

    double secondTemp = Math.log(endFraction.doubleValue());



    BigDecimal lambertConstant = new BigDecimal(startFraction - secondTemp);
    BigDecimal eulerNumber = BigDecimal.valueOf(EULER_NUMBER_MAIN_VALUE);
    BigDecimal bottom = new BigDecimal(LambertW
        .branchNeg1(lambertConstant.divide(eulerNumber, 1000, RoundingMode.HALF_UP).doubleValue()))
            .multiply(BigDecimal.valueOf(2));

    BigDecimal answer = lambertConstant.divide(bottom, 1000, RoundingMode.HALF_UP);
    return (int) Math.ceil(answer.doubleValue());

  }



}
