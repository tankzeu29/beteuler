package tests;

import euler.EulerStrategy;
import euler.factorial.CacheFact;

public class TestSingleThreadWithCacheFactorial extends BaseStrategyTests {


  TestSingleThreadWithCacheFactorial() {
    super(() -> EulerStrategy.singleCached(getFactorialSupplier()));
  }

  private static CacheFact getFactorialSupplier() {
    return CacheFact.of(TestConstants.MEDIUM_CACHE_SIZE);
  }
}
