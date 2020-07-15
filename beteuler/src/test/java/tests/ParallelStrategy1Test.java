package tests;

import euler.EulerStrategy;

public class ParallelStrategy1Test extends BaseStrategyTests {
  ParallelStrategy1Test() {
    super(() -> EulerStrategy.parallel(1));
  }
}
