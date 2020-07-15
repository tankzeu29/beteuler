package euler.strategy;


import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.stream.IntStream;
import app.logging.ApplicationLogger;
import euler.MathUtils;
import euler.factorial.Factorial;
import euler.utils.AnswerUtils;

/**
 * Parallel computation using ForkJoinedPool
 * 
 * @author Tankz
 *
 */

public class ParallelComputation extends AbstractStrategy {
  private final int numThreads;
  private Factorial factorialSupplier;
  private int originalPrecision;
  private int totaliterations;

  /**
   * Creates parallel computation using ForkJoinedPool and factorial supplier
   * 
   * @param numThreads - total threads
   * @param factorialSupplier - way to compute factorial
   */
  public ParallelComputation(int numThreads, Factorial factorialSupplier) {
    this.numThreads = numThreads;
    this.factorialSupplier = factorialSupplier;
  }

  @Override
  protected BigDecimal executeStrategy(int precision) {


    originalPrecision = precision;
    totaliterations = MathUtils.calculateIterations(precision) + 2;



    BigDecimal answer = BigDecimal.ZERO;
    try {
      answer = SharedForkJoinPool.get(numThreads).submit(computeEuler(totaliterations)).get();
    } catch (Exception e) {
      ApplicationLogger.getLogger().log(Level.SEVERE, "Failed computed result via ForkJoinedPool",
          e);
    }
    return AnswerUtils.formatAnswer(answer);



  }

  /**
   * Computes euler fraction using parallel streams
   * 
   * @param precision - precision to calculate the euler number after the decimal point
   * @return fraction result
   * @throws Exception
   */
  private Callable<BigDecimal> computeEuler(int precision) throws Exception {
    return () -> IntStream.range(0, precision).parallel()
        .mapToObj(i -> computeMember(i, originalPrecision + 2, factorialSupplier))
        .reduce(BigDecimal.ZERO, (current, sumSoFar) -> sumSoFar.add(current));

  }

  @Override
  public String toString() {
    return "Parallel computaiton  using threads=" + numThreads;
  }
}
