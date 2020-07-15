package user;

import user.account.Account;
import user.bonuses.UserBonus;

public class PowerUser extends User {

  public PowerUser(String username, String email, Account account) {
    super(username, email, account, UserBonus.getPowerUserBonus());

  }

}
