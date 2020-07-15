package euler.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import euler.factorial.Factorial;


/*
 * Abstract strategy to calculate the Euler number
 */
public abstract class AbstractStrategy {

  /**
   * Executes strategy
   * 
   * @param precision - precision to execute strategy
   * @return computed euler number with precision
   */
  protected abstract BigDecimal executeStrategy(int precision);

  /**
   * Computes Euler number with precision
   * 
   * @param precision - precision to compute Euler number
   * @return euler number
   */
  public BigDecimal computeEulerNumber(int precision) {
    return executeStrategy(precision);
  }


  /**
   * Computes euler fraction
   * 
   * @param number - number of a fraction index
   * @param scale - scale of the computation result
   * @param factorialSupplier - way to compute factorial
   * @return euler fraction result
   */
  protected static BigDecimal computeMember(int number, int scale, Factorial factorialSupplier) {

    final BigDecimal dominator = new BigDecimal((2 * number) + 1);
    final BigDecimal enumenator = new BigDecimal(factorialSupplier.get(2 * number));

    BigDecimal answer = dominator.divide(enumenator, scale, RoundingMode.HALF_UP);


    return answer;


  }


  /**
   * Return description of the strategy
   * 
   * @return strategy description
   */
  @Override
  public String toString() {
    return "Base strategy";
  }



}
