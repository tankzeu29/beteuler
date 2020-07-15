package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 4 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy4Test extends BaseStrategyTests {
  ParallelStrategy4Test() {
    super(() -> EulerStrategy.parallel(4));
  }
}
