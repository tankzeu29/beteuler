package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 2 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy2Test extends BaseStrategyTests {
  ParallelStrategy2Test() {
    super(() -> EulerStrategy.parallel(2));
  }
}
