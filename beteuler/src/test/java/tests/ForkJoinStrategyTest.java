package tests;

import euler.EulerStrategy;

public class ForkJoinStrategyTest extends BaseStrategyTests {
  ForkJoinStrategyTest() {
    super(() -> EulerStrategy.commonForkJoin());
  }
}
