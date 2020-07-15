package euler.factorial;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.stream.LongStream;
import app.logging.ApplicationLogger;

/**
 * Paralell computation of Euler number using ExecutorService
 * 
 * @author Tankz
 *
 */
public class ParallelFactorial implements Factorial {
  private final ExecutorService executorService;

  /**
   * Creates Parallel factorial executor
   * 
   * @param executorService - executor service
   */
  public ParallelFactorial(ExecutorService executorService) {
    this.executorService = executorService;
  }

  /**
   * Retrieves factorial
   * 
   */
  @Override
  public BigInteger get(long number) {



    try {
      return executorService
          .submit(() -> LongStream.range(2, number + 1).parallel().mapToObj(BigInteger::valueOf)
              .reduce(BigInteger.ONE, (current, factSoFar) -> factSoFar.multiply(current)))
          .get();
    } catch (InterruptedException | ExecutionException e) {
      ApplicationLogger.getLogger().log(Level.SEVERE, "Failed to parse parameters", e);
    }
    return BigInteger.ZERO;



  }
}
