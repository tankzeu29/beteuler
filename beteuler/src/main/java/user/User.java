package user;

import java.math.BigDecimal;
import user.account.Account;

public abstract class User {



  private String username;
  private String email;
  private Account account;
  private BigDecimal winBonus = BigDecimal.ONE;



  private User() {

  }



  public User(String username, String email, Account account, BigDecimal winBonus) {
    this.username = username;
    this.email = email;
    this.account = account;
    this.winBonus = winBonus;
  }

  public Account getAccount() {
    return account;
  }



  public void setAccount(Account account) {
    this.account = account;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public BigDecimal getWinBonus() {
    return winBonus;
  }



  public void setWinBonus(BigDecimal winBonus) {
    this.winBonus = winBonus;
  }



}
