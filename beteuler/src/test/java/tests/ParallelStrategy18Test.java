package tests;

import euler.EulerStrategy;

/**
 * Tests Executor service strategy with 18 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy18Test extends BaseStrategyTests {
  ParallelStrategy18Test() {
    super(() -> EulerStrategy.parallel(18));
  }
}
