package bet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import bet.generator.BetOddsGenerator;
import bet.options.BetChoice;

/**
 * Represents game bet
 * 
 * @author Tankz
 *
 */
public class Bet {

  private BigDecimal odd;
  private BigDecimal bound;
  private String description;
  private BetChoice betChoice;
  private BigDecimal betMoney;
  private BetOptions betOptions;


  /**
   * Hide this constructor because empty bets do not exist.
   */
  private Bet() {

  }

  /**
   * Creates bet instance for players to bet on.
   * 
   * @param description - description of the bet
   * @param betChoice - bet choice
   * @param betMoney - bet money
   * @param betOptions - additional bet options
   */
  public Bet(String description, BetChoice betChoice, BigDecimal betMoney, BetOptions betOptions) {
    this.odd = BetOddsGenerator.generateBetOdd();
    this.bound = BetOddsGenerator.generateBound();
    this.description = description;
    this.betChoice = betChoice;
    this.betMoney = betMoney;
    this.betMoney.setScale(5, RoundingMode.DOWN);
    this.betOptions = betOptions;
  }


  /**
   * Retrieves the bet odd
   * 
   * @return bet odd
   */
  public BigDecimal getOdd() {
    return odd;
  }


  /**
   * Retrieves the bet result bound
   * 
   * @return bet result bound
   */
  public BigDecimal getBound() {
    return bound;
  }


  /**
   * Bet description
   * 
   * @return bet descripton
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Retrieve bet choice
   * 
   * @return bet choicce
   */
  public BetChoice getBetChoice() {
    return betChoice;
  }


  /**
   * Bet money
   * 
   * @return bet money
   */
  public BigDecimal getBetMoney() {
    return betMoney;
  }


  /**
   * Bet options
   * 
   * @return bet options
   */
  public BetOptions getBetOptions() {
    return betOptions;
  }



}
