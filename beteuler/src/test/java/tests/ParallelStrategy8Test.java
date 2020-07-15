package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 8 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy8Test extends BaseStrategyTests {
  ParallelStrategy8Test() {
    super(() -> EulerStrategy.parallel(8));
  }
}
