package user;

import user.account.Account;
import user.bonuses.UserBonus;

public class DefaultUser extends User {

  public DefaultUser(String username, String email, Account account) {
    super(username, email, account, UserBonus.getPowerUserBonus());

  }

}
