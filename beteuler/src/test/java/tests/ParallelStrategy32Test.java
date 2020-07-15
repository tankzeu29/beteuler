package tests;

import euler.EulerStrategy;

public class ParallelStrategy32Test extends BaseStrategyTests {
  ParallelStrategy32Test() {
    super(() -> EulerStrategy.parallel(32));
  }
}
