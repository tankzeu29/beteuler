package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 16 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy16Test extends BaseStrategyTests {
  ParallelStrategy16Test() {
    super(() -> EulerStrategy.parallel(16));
  }
}
