package bet.generator;

import java.math.BigDecimal;

public class BetOddsGenerator {

  private static final BigDecimal MIN_BET_COEFFICIENT = BigDecimal.valueOf(1.8);
  private static final BigDecimal MAX_BET_COEFFICIENT = BigDecimal.valueOf(2.2);
  private static final BigDecimal MIN_BET_BOUND = BigDecimal.valueOf(1);
  private static final BigDecimal MAX_BET_BOUND = BigDecimal.valueOf(10000);

  private BetOddsGenerator() {

  }



  public static BigDecimal generateBetOdd() {
    return generateRandomCoeffiecent(MIN_BET_COEFFICIENT, MAX_BET_COEFFICIENT);
  }


  public static BigDecimal generateBound() {
    return generateRandomCoeffiecent(MIN_BET_BOUND, MAX_BET_BOUND);
  }

  private static BigDecimal generateRandomCoeffiecent(BigDecimal startBound, BigDecimal endBound) {
    BigDecimal betRange = endBound.subtract(startBound);
    BigDecimal randomNumber = BigDecimal.valueOf(Math.random());
    BigDecimal betOffset = betRange.multiply(randomNumber);
    BigDecimal result = startBound.add(betOffset);
    return result;
  }
}
