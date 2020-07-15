package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 32 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy32Test extends BaseStrategyTests {
  ParallelStrategy32Test() {
    super(() -> EulerStrategy.parallel(32));
  }
}
