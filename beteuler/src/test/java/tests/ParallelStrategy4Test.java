package tests;

import euler.EulerStrategy;

public class ParallelStrategy4Test extends BaseStrategyTests {
  ParallelStrategy4Test() {
    super(() -> EulerStrategy.parallel(4));
  }
}
