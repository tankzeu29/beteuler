package tests;

import euler.EulerStrategy;

public class TestSingleThreadStrategy extends BaseStrategyTests {
  TestSingleThreadStrategy() {
    super(EulerStrategy::single);
  }
}
