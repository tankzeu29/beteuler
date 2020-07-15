package tests;

import euler.EulerStrategy;

/**
 * Tests single thread strategy
 * 
 * @author Tankz
 *
 */
public class TestSingleThreadStrategy extends BaseStrategyTests {
  TestSingleThreadStrategy() {
    super(EulerStrategy::single);
  }
}
