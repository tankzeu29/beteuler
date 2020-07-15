package tests;

import euler.EulerStrategy;

/**
 * Fork join strategy test
 * 
 * @author Tankz
 *
 */
public class ForkJoinStrategyTest extends BaseStrategyTests {
  ForkJoinStrategyTest() {
    super(() -> EulerStrategy.commonForkJoin());
  }
}
