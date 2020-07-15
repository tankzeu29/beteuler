package tests;

import euler.EulerStrategy;

public class ParallelStrategy18Test extends BaseStrategyTests {
  ParallelStrategy18Test() {
    super(() -> EulerStrategy.parallel(18));
  }
}
