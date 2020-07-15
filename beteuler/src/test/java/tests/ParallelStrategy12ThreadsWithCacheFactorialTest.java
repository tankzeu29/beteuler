package tests;

import euler.EulerStrategy;
import euler.factorial.CacheFact;

public class ParallelStrategy12ThreadsWithCacheFactorialTest extends BaseStrategyTests {
  private ParallelStrategy12ThreadsWithCacheFactorialTest() {
    super(() -> EulerStrategy.parallelCachedFactorial(12, getFactorialSupplier()));
  }

  private static CacheFact getFactorialSupplier() {
    return CacheFact.of(10000);
  }
}
