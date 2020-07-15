package tests;

import euler.EulerStrategy;
import euler.factorial.CacheFact;

/**
 * Tests executor service with cached factoriel of 10000 and 12 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy12ThreadsWithCacheFactorialTest extends BaseStrategyTests {
  private ParallelStrategy12ThreadsWithCacheFactorialTest() {
    super(() -> EulerStrategy.parallelCachedFactorial(12, getFactorialSupplier()));
  }

  private static CacheFact getFactorialSupplier() {
    return CacheFact.of(10000);
  }
}
