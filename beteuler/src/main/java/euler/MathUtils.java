package euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.stream.LongStream;
import euler.strategy.LambertW;

public class MathUtils {

  private final static double EULER_NUMBER_MAIN_VALUE = 2.71;
  private final static int START_RANGE = 2;

  public static BigInteger factorial(final long step) {
    return LongStream.range(START_RANGE, step + 1).mapToObj(BigInteger::valueOf)
        .reduce(BigInteger.ONE, (current, factSoFar) -> factSoFar.multiply(current));
  }

  public static int calculateIterations(int precision) {
    return aprox(precision) + 1;

  }


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
