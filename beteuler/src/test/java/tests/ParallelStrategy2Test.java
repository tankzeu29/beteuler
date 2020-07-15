package tests;

import euler.EulerStrategy;

public class ParallelStrategy2Test extends BaseStrategyTests {
  ParallelStrategy2Test() {
    super(() -> EulerStrategy.parallel(2));
  }
}
