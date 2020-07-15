package euler;


import java.util.concurrent.ForkJoinPool;
import euler.factorial.DivideAndConquerFactorialSupplier;
import euler.factorial.Factorial;
import euler.factorial.ParallelFactorial;
import euler.factorial.StandartFactorialSupplier;
import euler.strategy.AbstractStrategy;
import euler.strategy.CustomThreadStrategy;
import euler.strategy.ForkJoinStrategy;
import euler.strategy.ParallelComputation;
import euler.strategy.SharedForkJoinPool;
import euler.strategy.SingleThread;

/*
 * Generates Strategy to compute Euler number
 */
public class EulerStrategy {

  /**
   * Parallel pool strategy with total threads and factorial cache
   * 
   * @param numThreads - total threads to be used
   * @param factorialCache - factorial cache
   * @return Parallel strategy
   */
  public static AbstractStrategy parallelCachedFactorial(int numThreads, Factorial factorialCache) {
    return new ParallelComputation(numThreads, factorialCache);
  }

  /**
   * Parallel pool strategy with total threads and factorial cache
   * 
   * @param numThreads - total threads to be used
   * @return Parallel strategy
   */
  public static AbstractStrategy parallel(int numThreads) {
    return new ParallelComputation(numThreads,
        new ParallelFactorial(SharedForkJoinPool.get(numThreads)));
  }

  /**
   * Parallel pool strategy with total threads and factorial Divide and conquer strategy
   * 
   * @param numThreads - total threads to be used
   * @return Parallel strategy
   */
  public static AbstractStrategy parallelDC(int numThreads) {
    return new ParallelComputation(numThreads, new DivideAndConquerFactorialSupplier());
  }

  /**
   * Single thread computation strategy
   * 
   * @return Single thread strategy
   */
  public static AbstractStrategy single() {
    return new SingleThread(new StandartFactorialSupplier());
  }

  /**
   * Single thread computation strategy with factorial cache
   * 
   * @param factorialCache - cache for factorials
   * @return Single thread strategy
   */
  public static AbstractStrategy singleCached(Factorial factorialCache) {
    return new SingleThread(factorialCache);
  }

  /**
   * Single thread computation strategy with Divide and conquer strategy for computation
   * 
   * @return Single thread strategy
   */
  public static AbstractStrategy singleDC() {
    return new SingleThread(new DivideAndConquerFactorialSupplier());
  }

  /**
   * For join pool strategy
   * 
   * @return For join pool strategy
   */
  public static AbstractStrategy commonForkJoin() {
    return new ForkJoinStrategy(new ParallelFactorial(ForkJoinPool.commonPool()));
  }

  /**
   * Strategy by creating custom threads and executing them
   * 
   * @param numThreads - total threads used
   * @param factorialCache - type of cache to be used
   * @return Custom thread strategy
   */
  public static AbstractStrategy sellfStrategy(int numThreads, Factorial factorialCache) {
    return new CustomThreadStrategy(numThreads, factorialCache);
  }


}
