package bet.operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.logging.Level;
import app.logging.ApplicationLogger;
import app.modes.ComputeMode;
import app.modes.FactorialMode;
import bet.Bet;
import bet.BetOptions;
import bet.options.BetChoice;
import euler.EulerFileWriter;
import euler.EulerStrategy;
import euler.MathUtils;
import euler.factorial.CacheFact;
import euler.strategy.AbstractStrategy;
import euler.timer.Timer;
import user.User;
import user.account.Account;

/**
 * Bet operator computing bets
 */
public class BetOperator {

  /**
   * All playing users
   */
  private Map<String, User> playingUsers;
  /**
   * current bet games
   */
  private Map<User, List<Bet>> currentBetGames;

  /**
   * creates Bet operator
   */
  public BetOperator() {
    playingUsers = new HashMap<>();
    currentBetGames = new HashMap<>();
  }


  /**
   * Creates bet for a user with bet amount and particular bet
   * 
   * @param user - user that created the bet
   * @param bet - bet the user bet on
   * @param amount - money bet from the user
   */
  public void addBet(User user, Bet bet, BigDecimal amount) {

    String username = user.getUsername();
    if (playingUsers.containsKey(username)) {
      playingUsers.put(username, user);

    }

    currentBetGames.putIfAbsent(user, new ArrayList<Bet>());
    List<Bet> userBets = currentBetGames.get(user);

    userBets.add(bet);


  }

  /**
   * Calculates the wins/losses for all bets
   */
  public void calculateAllBets() {
    for (Entry<User, List<Bet>> betEntry : currentBetGames.entrySet()) {
      User user = betEntry.getKey();
      List<Bet> userBets = betEntry.getValue();
      for (Bet bet : userBets) {
        BigDecimal betResult = findBetResult(bet.getBetOptions());
        deduceBetOutcome(user, bet, betResult);
      }
    }
  }


  /**
   * Starts a bet and calculates the time it took to be computed
   * 
   * @param betOptions - bet options of a bet
   * @return the time it took for a bet to complete
   */
  private BigDecimal findBetResult(BetOptions betOptions) {
    Timer timer = createCalculatingBetTimer(betOptions.getCalculateMode(),
        betOptions.getRepeptitions(), betOptions.getFactMode(), betOptions.getTotalThreads(),
        betOptions.getPrecision(), betOptions.getFileResultPath());
    double avgTime = timer.time().stream().mapToLong(l -> l).average().getAsDouble();
    System.out.println("Total time :" + avgTime + " (ms)");
    BigDecimal betTimeResult = new BigDecimal(avgTime);
    return betTimeResult;
  }

  /**
   * Deduces if a player has won a bet or not
   * 
   * @param user - user that created a bet
   * @param bet - the user bet
   * @param betResult - result from the bet
   */
  private void deduceBetOutcome(User user, Bet bet, BigDecimal betResult) {

    Account userAccount = user.getAccount();
    BetChoice betChoice = bet.getBetChoice();


    if (bet.getBound().compareTo(betResult) > 0 && betChoice.equals(BetChoice.OVER)) {
      BigDecimal wonMoney = bet.getOdd().multiply(bet.getBetMoney());
      wonMoney = wonMoney.multiply(user.getWinBonus());
      System.out.println("You have won " + wonMoney + " LV.");
      userAccount.addToBalance(wonMoney);
    } else {

      BigDecimal lostMoney = bet.getBetMoney();
      System.out.println("You have lost " + lostMoney + " LV.");
      userAccount.reduceBalance(bet.getBetMoney());
    }

  }

  /**
   * Creates timer with a bet
   * 
   * @param betMode - mode to be used for computation
   * @param repetitions - total repetitions of the bet computation
   * @param factMode - factorial mode to be used for calculation
   * @param numThreads - total threads to be used for computation
   * @param precision - precision after the decimal point of the decimal number
   * @param outputPath - destination where the result should be saved
   * @return timer with strategy to calculate bet
   */
  private Timer createCalculatingBetTimer(String betMode, int repetitions, String factMode,
      int numThreads, int precision, String outputPath) {
    Timer timer;


    Consumer<AbstractStrategy> calculator = (strategy) -> {

      BigDecimal eulerNumber;
      try {
        eulerNumber = strategy.computeEulerNumber(precision);
        EulerFileWriter.writeToFile(eulerNumber, outputPath);
      } catch (Exception e) {
        System.out.println("Failed to compute euler number");
        ApplicationLogger.getLogger().log(Level.SEVERE, "Failed to compute euler number", e);
      }


    };


    if (FactorialMode.CACHED.getValue().equals(factMode)
        && ComputeMode.SINGLE.getValue().equals(betMode)) {
      timer = new Timer(repetitions, () -> {
        CacheFact factorialCache = CacheFact.of(precision);
        AbstractStrategy strategy = EulerStrategy.singleCached(factorialCache);
        calculator.accept(strategy);
      });
    } else if (ComputeMode.SINGLE.getValue().equals(betMode)
        && FactorialMode.DC.getValue().equals(factMode)) {
      timer = new Timer(repetitions, () -> {
        AbstractStrategy strategy = EulerStrategy.singleDC();
        calculator.accept(strategy);
      });
    } else if (ComputeMode.SHARED.getValue().equals(betMode)) {
      timer = new Timer(repetitions, () -> {
        AbstractStrategy strategy = EulerStrategy.commonForkJoin();
        calculator.accept(strategy);
      });
    } else if (ComputeMode.SINGLE.getValue().equals(betMode)) {
      timer = new Timer(repetitions, () -> {
        AbstractStrategy strategy = EulerStrategy.single();
        calculator.accept(strategy);
      });
    }



    else if (ComputeMode.PARALLEL.getValue().equals(betMode)
        && FactorialMode.CACHED.getValue().equals(factMode)) {
      timer = new Timer(repetitions, () -> {
        CacheFact factorialCache = CacheFact.of(MathUtils.calculateIterations(precision));

        AbstractStrategy strategy =
            EulerStrategy.parallelCachedFactorial(numThreads, factorialCache);
        calculator.accept(strategy);
      });
    } else if (ComputeMode.SINGLE.getValue().equals(betMode)
        && FactorialMode.DC.getValue().equals(factMode)) {
      timer = new Timer(repetitions, () -> {
        AbstractStrategy strategy = EulerStrategy.parallelDC(numThreads);
        calculator.accept(strategy);
      });
    } else if (ComputeMode.SELF.getValue().equals(betMode)) {
      timer = new Timer(repetitions, () -> {

        CacheFact factorialCache = CacheFact.of(MathUtils.calculateIterations(precision));
        AbstractStrategy strategy = EulerStrategy.sellfStrategy(numThreads, factorialCache);
        calculator.accept(strategy);

      });
    }

    else {
      timer = new Timer(repetitions, () -> {
        AbstractStrategy strategy = EulerStrategy.parallel(numThreads);
        calculator.accept(strategy);
      });
    }

    return timer;
  }



}
