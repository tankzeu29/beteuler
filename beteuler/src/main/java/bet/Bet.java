package bet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import bet.generator.BetOddsGenerator;
import bet.options.BetChoice;

public class Bet {

  private BigDecimal odd;
  private BigDecimal bound;
  private String description;
  private BetChoice betChoice;
  private BigDecimal betMoney;
  private BetOptions betOptions;



  private Bet() {

  }

  public Bet(String description, BetChoice betChoice, BigDecimal betMoney, BetOptions betOptions) {
    this.odd = BetOddsGenerator.generateBetOdd();
    this.bound = BetOddsGenerator.generateBound();
    this.description = description;
    this.betChoice = betChoice;
    this.betMoney = betMoney;
    this.betMoney.setScale(5, RoundingMode.DOWN);
    this.betOptions = betOptions;
  }


  public BigDecimal getOdd() {
    return odd;
  }

  public void setOdd(BigDecimal odd) {
    this.odd = odd;
  }

  public BigDecimal getBound() {
    return bound;
  }

  public void setBound(BigDecimal bound) {
    this.bound = bound;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BetChoice getBetChoice() {
    return betChoice;
  }

  public void setBetChoice(BetChoice betChoice) {
    this.betChoice = betChoice;
  }

  public BigDecimal getBetMoney() {
    return betMoney;
  }

  public void setBetMoney(BigDecimal betMoney) {
    this.betMoney = betMoney;
  }

  public BetOptions getBetOptions() {
    return betOptions;
  }

  public void setBetOptions(BetOptions betOptions) {
    this.betOptions = betOptions;
  }



}
