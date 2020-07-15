package user.account;

import java.math.BigDecimal;

/**
 * Represents account to bet from
 * 
 * @author Tankz
 *
 */
public class Account {

  /**
   * Start betting bonus
   */
  private static final int START_BALANCE = 100;
  private BigDecimal balance;
  private String IBAN;

  /**
   * Creates account with IBAN
   * 
   * @param IBAN - card ID
   */
  public Account(String IBAN) {
    this.IBAN = IBAN;
    this.balance = BigDecimal.valueOf(START_BALANCE);
  }


  /**
   * Retrieves account IBAN
   * 
   * @return account IBAN
   */
  public String getIBAN() {
    return IBAN;
  }


  /**
   * Retrieves account balance
   * 
   * @return account balance
   */
  public BigDecimal getBalance() {
    return balance;
  }


  /**
   * Adds sum to balance
   * 
   * @param sum - sum to be added
   */
  public void addToBalance(BigDecimal sum) {
    balance = balance.add(sum);
  }

  /**
   * Reduces account sum
   * 
   * @param sum - sum to be removed from the account balance
   */
  public void reduceBalance(BigDecimal sum) {
    balance = balance.subtract(sum);
  }


}
