package euler.strategy;


import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import euler.MathUtils;
import euler.factorial.Factorial;
import euler.utils.AnswerUtils;


public class ParallelComputation extends AbstractStrategy {
  private final int numThreads;
  private Factorial factorialSupplier;
  private int originalPrecision;
  private int totaliterations;

  public ParallelComputation(int numThreads, Factorial factorialSupplier) {
    this.numThreads = numThreads;
    this.factorialSupplier = factorialSupplier;
  }

  @Override
  protected BigDecimal executeStrategy(int precision) throws Exception {


    originalPrecision = precision;
    totaliterations = MathUtils.calculateIterations(precision) + 2;



    BigDecimal answer =
        SharedForkJoinPool.get(numThreads).submit(computeEuler(totaliterations)).get();
    return AnswerUtils.formatAnswer(answer);


  }

  private Callable<BigDecimal> computeEuler(int precision) {
    return () -> IntStream.range(0, precision).parallel()
        .mapToObj(i -> computeMember(i, originalPrecision + 2, factorialSupplier))
        .reduce(BigDecimal.ZERO, (current, sumSoFar) -> sumSoFar.add(current));

  }

  @Override
  public String toString() {
    return "Parallel computaiton  using threads=" + numThreads;
  }
}
