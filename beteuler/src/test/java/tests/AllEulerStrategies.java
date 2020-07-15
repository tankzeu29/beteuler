package tests;


import java.util.concurrent.ForkJoinPool;
import euler.factorial.DivideAndConquerFactorialSupplier;
import euler.factorial.Factorial;
import euler.factorial.ParallelFactorial;
import euler.factorial.StandartFactorialSupplier;
import euler.strategy.AbstractStrategy;
import euler.strategy.ForkJoinStrategy;
import euler.strategy.ParallelComputation;
import euler.strategy.SharedForkJoinPool;
import euler.strategy.SingleThread;

public class AllEulerStrategies {

  public static AbstractStrategy parallelCachedFactorial(int numThreads, Factorial factorialCache) {
    return new ParallelComputation(numThreads, factorialCache);
  }

  public static AbstractStrategy parallel(int numThreads) {
    return new ParallelComputation(numThreads,
        new ParallelFactorial(SharedForkJoinPool.get(numThreads)));
  }

  public static AbstractStrategy parallelDC(int numThreads) {
    return new ParallelComputation(numThreads, new DivideAndConquerFactorialSupplier());
  }

  public static AbstractStrategy single() {
    return new SingleThread(new StandartFactorialSupplier());
  }

  public static AbstractStrategy singleCached(Factorial factorialCache) {
    return new SingleThread(factorialCache);
  }

  public static AbstractStrategy singleDC() {
    return new SingleThread(new DivideAndConquerFactorialSupplier());
  }

  public static AbstractStrategy commonForkJoin() {
    return new ForkJoinStrategy(new ParallelFactorial(ForkJoinPool.commonPool()));
  }

}
