package app.input;

import bet.options.BetChoice;

public class InputConverter {


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
