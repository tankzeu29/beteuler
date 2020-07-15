package app.input;

import bet.options.BetChoice;

/*
 * Converts bet choice of the user from the console
 */
public class InputConverter {

  private InputConverter() {

  }

  /**
   * 
   * Converts from String bet option of the user
   * 
   * @param betOption - bet option of the user
   * @return converted bet option
   */
  public static BetChoice convertStringToBetChoice(String betOption) {
    BetChoice userBetChoice = BetChoice.OVER;
    for (BetChoice betChoice : BetChoice.values()) {
      if (betChoice.getValue().equals(betOption)) {
        userBetChoice = betChoice;
        break;
      }
    }
    return userBetChoice;

  }
}
