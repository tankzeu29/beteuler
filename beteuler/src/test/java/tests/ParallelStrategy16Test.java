package tests;

import euler.EulerStrategy;

public class ParallelStrategy16Test extends BaseStrategyTests {
  ParallelStrategy16Test() {
    super(() -> EulerStrategy.parallel(16));
  }
}
