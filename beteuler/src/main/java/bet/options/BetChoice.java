package bet.options;

/**
 * Player bet choice
 * 
 * @author Tankz
 *
 */
public enum BetChoice implements GameOption {

  OVER("over"), UNDER("under");

  private String betType;

  /**
   * Creates player bet choice
   * 
   * @param betType - type of betting
   */
  BetChoice(String betType) {
    this.betType = betType;
  }

  /**
   * Retrieves the bet choice value
   * 
   * @return bet choice value
   */
  @Override
  public String getValue() {
    return betType;
  }
}
