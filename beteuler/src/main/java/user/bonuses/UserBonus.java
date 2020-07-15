package user.bonuses;

import java.math.BigDecimal;

/**
 * User bonuses on win
 * 
 * @author Tankz
 *
 */
public class UserBonus {
  /**
   * Power user bonus
   */
  private static final double POWER_USER_BONUS_COEFFICIENT = 1.25;
  /**
   * Default user bonus
   */
  private static final double DEFAULT_USER_BONUS_COEFFICIENT = 1.00;

  private UserBonus() {

  }

  /**
   * Power user bonus
   */
  private static final BigDecimal POWER_USER_BONUS =
      BigDecimal.valueOf(POWER_USER_BONUS_COEFFICIENT);

  /**
   * Default user bonus
   */
  private static final BigDecimal DEFAULT_USER_BONUS =
      BigDecimal.valueOf(DEFAULT_USER_BONUS_COEFFICIENT);

  /**
   * Retrieves power user bonus
   * 
   * @return power user bonus
   */
  public static BigDecimal getPowerUserBonus() {
    return POWER_USER_BONUS;
  }

  /**
   * Default user bonus
   * 
   * @return default user bonus
   */
  public static BigDecimal getDefaultUserBonus() {
    return DEFAULT_USER_BONUS;
  }

}
