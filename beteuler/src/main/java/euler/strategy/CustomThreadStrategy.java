package euler.strategy;

import java.math.BigDecimal;
import java.util.logging.Level;
import app.logging.ApplicationLogger;
import euler.MathUtils;
import euler.factorial.Factorial;
import euler.utils.AnswerUtils;

/*
 * Starts custom threads which compute part of the Euler number , the results are combined to deduce
 * the total answer
 */
public class CustomThreadStrategy extends AbstractStrategy {

  private EulerThread[] threads;
  int totalThreads = 0;
  int totalIterations = 0;
  public Factorial factorialSupplier;

  /**
   * Creates custom thread strategy executing
   * 
   * @param numThreads - total threads to be started
   * @param factorialSupplier - way to compute factorial
   */
  public CustomThreadStrategy(int numThreads, Factorial factorialSupplier) {
    this.factorialSupplier = factorialSupplier;
    this.totalThreads = numThreads;
  }


  /**
   * Starts threads which compute the euler number by calculating a part of the euler number.The
   * work is distributed equally among all threads
   * 
   * @param precision - precision the compute the euler number
   * @return euler number
   */
  @Override
  protected BigDecimal executeStrategy(int precision) {

    totalIterations = MathUtils.calculateIterations(precision);

    threads = new EulerThread[totalThreads];
    for (int i = 0; i < totalThreads; i++) {
      threads[i] =
          new EulerThread(i, totalThreads, totalIterations, precision + 2, factorialSupplier);
      threads[i].start();

    }
    BigDecimal result = BigDecimal.ZERO;
    for (int i = 0; i < threads.length; i++) {

      try {
        threads[i].join();
      } catch (InterruptedException e) {
        ApplicationLogger.getLogger().log(Level.SEVERE,
            "Failed to compute euler partition in thread " + i, e);
        continue;
      }

      result = result.add(threads[i].getResult());
    }

    return AnswerUtils.formatAnswer(result);
  }

}
