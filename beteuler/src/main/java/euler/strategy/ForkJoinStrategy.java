package euler.strategy;

/**
 * This class represents the Fork join strategy
 * 
 */
import java.math.BigDecimal;
import java.util.stream.IntStream;
import euler.MathUtils;
import euler.factorial.Factorial;
import euler.utils.AnswerUtils;

public class ForkJoinStrategy extends AbstractStrategy {
  private final Factorial factorialSupplier;

  private int originalPrecision;
  private int totaliterations;

  /**
   * Fork join strategy
   * 
   * @param factorialSupplier - type of factorial computation
   */
  public ForkJoinStrategy(Factorial factorialSupplier) {

    this.factorialSupplier = factorialSupplier;
  }

  @Override
  protected BigDecimal executeStrategy(int precision) {

    totaliterations = MathUtils.calculateIterations(precision) + 2;
    originalPrecision = precision;
    BigDecimal answer = IntStream.range(0, totaliterations).parallel()
        .mapToObj(i -> computeMember(i, originalPrecision + 2, factorialSupplier))
        .reduce(BigDecimal.ZERO, (current, sumSoFar) -> sumSoFar.add(current));

    return AnswerUtils.formatAnswer(answer);
  }

  @Override
  public String toString() {
    return "Parallel factorial using common fork join pool";
  }
}
