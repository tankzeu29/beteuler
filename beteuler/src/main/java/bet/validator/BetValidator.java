package bet.validator;

import java.math.BigDecimal;
import bet.Bet;
import user.User;
import user.account.Account;

public class BetValidator {

  private BetValidator() {

  }


  public boolean isBetValid(User user, Bet bet, BigDecimal amount) {

    boolean isBetValid = true;
    if (user == null) {
      isBetValid = false;
    }

    if (bet == null) {
      isBetValid = false;
    }

    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      isBetValid = false;
    }

    Account userAccount = user.getAccount();
    if (userAccount == null) {
      isBetValid = false;
    }

    BigDecimal userBalance = userAccount.getBalance();
    if (userBalance.compareTo(BigDecimal.ZERO) < 0) {
      isBetValid = false;
    }

    return isBetValid;


  }
}
