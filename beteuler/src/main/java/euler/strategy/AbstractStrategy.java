package euler.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import euler.factorial.Factorial;


/*
 * Abstract strategy to calculate the Euler number
 */
public abstract class AbstractStrategy {


  protected abstract BigDecimal executeStrategy(int precision) throws Exception;

  public BigDecimal computeEulerNumber(int precision) throws Exception {
    return executeStrategy(precision);
  }



  protected static BigDecimal computeMember(int number, int scale, Factorial factorialSupplier) {

    final BigDecimal dominator = new BigDecimal((2 * number) + 1);
    final BigDecimal enumenator = new BigDecimal(factorialSupplier.get(2 * number));

    BigDecimal answer = dominator.divide(enumenator, scale, RoundingMode.HALF_UP);


    return answer;


  }



}
