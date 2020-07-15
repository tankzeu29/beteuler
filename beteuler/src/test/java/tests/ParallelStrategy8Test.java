package tests;

import euler.EulerStrategy;

public class ParallelStrategy8Test extends BaseStrategyTests {
  ParallelStrategy8Test() {
    super(() -> EulerStrategy.parallel(8));
  }
}
