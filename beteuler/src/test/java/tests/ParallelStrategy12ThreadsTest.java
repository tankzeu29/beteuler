package tests;

import euler.EulerStrategy;

/**
 * Tests executor service with 12 threads
 * 
 * @author Tankz
 *
 */
public class ParallelStrategy12ThreadsTest extends BaseStrategyTests {
  private static final int TOTAL_THREADS = 12;

  ParallelStrategy12ThreadsTest() {
    super(() -> EulerStrategy.parallel(TOTAL_THREADS));
  }
}
