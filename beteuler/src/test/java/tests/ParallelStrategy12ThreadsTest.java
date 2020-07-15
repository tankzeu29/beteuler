package tests;

import euler.EulerStrategy;

public class ParallelStrategy12ThreadsTest extends BaseStrategyTests {
  private static final int TOTAL_THREADS = 12;

  ParallelStrategy12ThreadsTest() {
    super(() -> EulerStrategy.parallel(TOTAL_THREADS));
  }
}
