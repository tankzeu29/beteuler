package app.run;


import java.math.BigDecimal;
import java.util.logging.Level;
import app.input.InputParser;
import app.input.InputPropertiesParser;
import app.logging.ApplicationLogger;
import bet.Bet;
import bet.BetOptions;
import bet.operator.BetOperator;
import bet.options.BetChoice;
import user.PowerUser;
import user.User;
import user.account.Account;

/**
 * Responsible for being starting point of the application
 * 
 */

public class AppRunner {

  private String[] commandArguments;
  public static final int availableProcessors = Runtime.getRuntime().availableProcessors();
  public static final int ONE_CORE = 1;
  private static BetOperator betOperator;

  /**
   * Creates application instance
   * 
   * @param commandArguments
   */
  AppRunner(String[] commandArguments) {
    this.commandArguments = commandArguments;
    betOperator = new BetOperator();
  }

  /**
   * Initializes the betting game
   */
  void run() {

    try {


      InputParser.parseCommandLine(commandArguments).ifPresent(commandLine -> {

        String mode = InputPropertiesParser.parseMode(commandLine);

        String outputPath = InputPropertiesParser.parseOutputPath(commandLine);

        String factMode = InputPropertiesParser.parseFactorialMode(commandLine);


        int numThreads = InputPropertiesParser.parseThreadsNumber(commandLine, mode);
        int precision = InputPropertiesParser.parsePrecision(commandLine);

        int repetitions = InputPropertiesParser.parseRepetitions(commandLine);
        String username = InputPropertiesParser.parseUsername(commandLine);
        String email = InputPropertiesParser.parseEmail(commandLine);
        String iban = InputPropertiesParser.parseIban(commandLine);

        double betMoney = InputPropertiesParser.parseBetMoney(commandLine);


        BetChoice userBetChoice = InputPropertiesParser.parseBetChoice(commandLine);


        Account account = new Account(iban);
        User user = new PowerUser(username, email, account);

        BigDecimal userBetMoney = new BigDecimal(betMoney);
        BetOptions betOptions =
            new BetOptions(mode, factMode, numThreads, precision, repetitions, outputPath);
        Bet bet = new Bet("Sample be", userBetChoice, userBetMoney, betOptions);

        betOperator.addBet(user, bet, userBetMoney);



      });
    } catch (Exception e) {
      ApplicationLogger.getLogger().log(Level.SEVERE, "Failed to parse parameters", e);
    }
  }

  /**
   * Starts computation of the bets
   */
  public void calculateBets() {
    betOperator.calculateAllBets();
  }

  /**
   * Entry point of the application.Reads the console parameters
   * 
   * @param args - command line arguments
   */
  public static void main(String[] args) {

    AppRunner appRunner = new AppRunner(args);
    appRunner.run();
    appRunner.calculateBets();
  }
}
