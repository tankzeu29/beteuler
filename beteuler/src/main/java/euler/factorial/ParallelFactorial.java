package euler.factorial;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.stream.LongStream;

public class ParallelFactorial implements Factorial {
  private final ExecutorService executorService;

  public ParallelFactorial(ExecutorService executorService) {
    this.executorService = executorService;
  }

  @Override
  public BigInteger get(long number) {


    try {
      return executorService
          .submit(() -> LongStream.range(2, number + 1).parallel().mapToObj(BigInteger::valueOf)
              .reduce(BigInteger.ONE, (current, factSoFar) -> factSoFar.multiply(current)))
          .get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    return BigInteger.ZERO;
  }
}
