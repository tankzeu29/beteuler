package bet.generator;

import java.math.BigDecimal;

/**
 * Generate bet odds
 *
 */
public class BetOddsGenerator {

  /*
   * Minimum bet coefficient
   */
  private static final BigDecimal MIN_BET_COEFFICIENT = BigDecimal.valueOf(1.8);
  /*
   * Maximum bet coefficient
   */
  private static final BigDecimal MAX_BET_COEFFICIENT = BigDecimal.valueOf(2.2);
  /**
   * Minimum bet result bound
   */
  private static final BigDecimal MIN_BET_BOUND = BigDecimal.valueOf(1);
  /**
   * Max bet result bound
   */
  private static final BigDecimal MAX_BET_BOUND = BigDecimal.valueOf(10000);

  private BetOddsGenerator() {

  }


  /**
   * Generate bet odd
   * 
   * @return bet odd
   */
  public static BigDecimal generateBetOdd() {
    return generateRandomCoeffiecent(MIN_BET_COEFFICIENT, MAX_BET_COEFFICIENT);
  }

  /**
   * Generates bound for over and under bets
   * 
   * @return over/under bound
   */
  public static BigDecimal generateBound() {
    return generateRandomCoeffiecent(MIN_BET_BOUND, MAX_BET_BOUND);
  }

  /**
   * Generates random over/under bet coefficient in the interval [minBound;maxBound]
   * 
   * @param minBound - minimum bound coefficient
   * @param maxBound - maximum bound coefficient
   * @return random coefficient
   */
  private static BigDecimal generateRandomCoeffiecent(BigDecimal minBound, BigDecimal maxBound) {
    BigDecimal betRange = maxBound.subtract(minBound);
    BigDecimal randomNumber = BigDecimal.valueOf(Math.random());
    BigDecimal betOffset = betRange.multiply(randomNumber);
    BigDecimal result = minBound.add(betOffset);
    return result;
  }
}
