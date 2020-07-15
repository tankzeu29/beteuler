package user.bonuses;

import java.math.BigDecimal;

public class UserBonus {
  private static final double POWER_USER_BONUS_COEFFICIENT = 1.25;
  private static final double DEFAULT_USER_BONUS_COEFFICIENT = 1.00;

  private UserBonus() {

  }

  private static final BigDecimal POWER_USER_BONUS =
      BigDecimal.valueOf(POWER_USER_BONUS_COEFFICIENT);

  private static final BigDecimal DEFAULT_USER_BONUS =
      BigDecimal.valueOf(DEFAULT_USER_BONUS_COEFFICIENT);

  public static BigDecimal getPowerUserBonus() {
    return POWER_USER_BONUS;
  }

  public static BigDecimal getDefaultUserBonus() {
    return DEFAULT_USER_BONUS;
  }

}
