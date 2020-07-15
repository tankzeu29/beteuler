package tests;

import java.util.concurrent.ForkJoinPool;
import euler.strategy.ParallelComputation;

public class TestParallelStrategyForkJoinedPool extends BaseStrategyTests {
  TestParallelStrategyForkJoinedPool() {
    super(() -> new ParallelComputation(Runtime.getRuntime().availableProcessors(),
        new euler.factorial.ParallelFactorial(ForkJoinPool.commonPool())));
  }
}
