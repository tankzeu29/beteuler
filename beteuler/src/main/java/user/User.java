package user;

import java.math.BigDecimal;
import user.account.Account;

/**
 * User playing the game
 * 
 * @author Tankz
 *
 */
public abstract class User {



  private String username;
  private String email;
  private Account account;
  private BigDecimal winBonus = BigDecimal.ONE;



  private User() {

  }


  /**
   * creates user using the application
   * 
   * @param username - user unique id name
   * @param email - user email
   * @param account - user account with which he plays
   * @param winBonus - win bonus on bettings
   */
  public User(String username, String email, Account account, BigDecimal winBonus) {
    this.username = username;
    this.email = email;
    this.account = account;
    this.winBonus = winBonus;
  }

  /**
   * Retrieves user account
   * 
   * @return user account
   */
  public Account getAccount() {
    return account;
  }


  /**
   * Retrieves user email
   * 
   * @return user email
   */
  public String getEmail() {
    return email;
  }


  /**
   * Retrieves user email
   * 
   * @return user email
   */
  public String getUsername() {
    return username;
  }

  /**
   * Retrieves win bonus
   * 
   * @return win bonus
   */
  public BigDecimal getWinBonus() {
    return winBonus;
  }



}
