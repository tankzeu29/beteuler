package bet.options;

public enum BetChoice implements GameOption {

  OVER("over"), UNDER("under");

  private String betType;

  BetChoice(String betType) {
    this.betType = betType;
  }

  @Override
  public String getValue() {
    return betType;
  }
}
