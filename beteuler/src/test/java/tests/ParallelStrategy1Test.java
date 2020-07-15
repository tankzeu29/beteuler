package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 1 thread
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy1Test extends BaseStrategyTests {
  ParallelStrategy1Test() {
    super(() -> EulerStrategy.parallel(1));
  }
}
