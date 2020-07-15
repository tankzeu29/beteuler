package user.account;

import java.math.BigDecimal;

public class Account {

  private static final int START_BALANCE = 100;
  private BigDecimal balance;
  private String IBAN;

  public Account(String IBAN) {
    this.IBAN = IBAN;
    this.balance = BigDecimal.valueOf(START_BALANCE);
  }


  public String getIBAN() {
    return IBAN;
  }

  public void setIBAN(String iBAN) {
    IBAN = iBAN;
  }


  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal newBalance) {
    this.balance = newBalance;
  }

  public void addToBalance(BigDecimal sum) {
    balance = balance.add(sum);
  }

  public void reduceBalance(BigDecimal sum) {
    balance = balance.subtract(sum);
  }


}
