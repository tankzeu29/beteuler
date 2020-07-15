package euler.strategy;

import java.math.BigDecimal;
import euler.MathUtils;
import euler.factorial.Factorial;
import euler.utils.AnswerUtils;


public class CustomThreadStrategy extends AbstractStrategy {

  private EulerThread[] threads;
  int totalThreads = 0;
  int totalIterations = 0;
  public Factorial factorialSupplier;

  public CustomThreadStrategy(int numThreads, Factorial factorialSupplier) {
    this.factorialSupplier = factorialSupplier;
    this.totalThreads = numThreads;
  }

  @Override
  protected BigDecimal executeStrategy(int precision) throws InterruptedException {

    totalIterations = MathUtils.calculateIterations(precision);

    threads = new EulerThread[totalThreads];
    for (int i = 0; i < totalThreads; i++) {
      threads[i] =
          new EulerThread(i, totalThreads, totalIterations, precision + 2, factorialSupplier);
      threads[i].start();

    }
    BigDecimal result = BigDecimal.ZERO;
    for (int i = 0; i < threads.length; i++) {

      threads[i].join();

      result = result.add(threads[i].getResult());
    }

    return AnswerUtils.formatAnswer(result);
  }

}
