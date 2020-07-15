package euler.strategy;

import java.math.BigDecimal;
import euler.MathUtils;
import euler.factorial.Factorial;
import euler.utils.AnswerUtils;

/**
 * Single thread strategy
 * 
 * @author Tankz
 *
 */
public class SingleThread extends AbstractStrategy {

  private final Factorial factorialSupplier;

  /**
   * Creates single thread to compute Euler number with factorial supplier
   * 
   * @param factorialSupplier - way to compute the factorials
   */
  public SingleThread(Factorial factorialSupplier) {
    this.factorialSupplier = factorialSupplier;
  }

  @Override
  protected BigDecimal executeStrategy(int precision) {


    BigDecimal answer = BigDecimal.ZERO;
    int totalIterations = MathUtils.calculateIterations(precision);
    for (int i = 0; i < totalIterations; i++) {
      answer = answer.add(computeMember(i, precision + 2, factorialSupplier));

    }


    return AnswerUtils.formatAnswer(answer);
  }

  @Override
  public String toString() {
    return "Single thread ";
  }
}
