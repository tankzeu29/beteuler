package app.input;

import org.apache.commons.cli.CommandLine;
import app.modes.ComputeMode;
import bet.options.BetChoice;

/**
 * Parses game properties
 */
public class InputPropertiesParser {

  /**
   * Prevent from initialization
   */
  private InputPropertiesParser() {

  }

  /**
   * Parses the mode of computation of the bet
   * 
   * @param commandLine - command line arguments
   * @return computation parse mode
   */
  public static String parseMode(CommandLine commandLine) {

    String mode = InputParser.getOptionValue(commandLine, CmdOption.MODE);
    if (!InputValidator.isComputationModeValid(mode)) {
      throw new IllegalArgumentException("Computaiton mode  is not valid");
    }

    return mode;
  }

  public static String parseOutputPath(CommandLine commandLine) {



    String outputPath = InputParser.getOptionValue(commandLine, CmdOption.OUTPUT);
    System.out.println(outputPath);
    if (!InputValidator.isOutputPathValid(outputPath)) {
      throw new IllegalArgumentException("Output path  is not valid");
    }
    return outputPath;
  }

  /**
   * Parses command line parameter for factorial mode
   * 
   * @param commandLine - command line arguments
   * @return factorial mode
   */
  public static String parseFactorialMode(CommandLine commandLine) {



    String factorialMode = InputParser.getOptionValue(commandLine, CmdOption.FACT_MODE);

    if (!InputValidator.isFactorialModeValid(factorialMode)) {
      throw new IllegalArgumentException("Output path  is not valid");
    }
    return factorialMode;
  }

  /**
   * Retrieves the number of threads the bet will be started with
   * 
   * @param commandLine - command line arguments
   * @param computationMode - computation mode
   * @return total threads to be used
   */
  public static int parseThreadsNumber(CommandLine commandLine, String computationMode) {
    int numThreads = ComputeMode.SINGLE.getValue().equals(computationMode) ? 1
        : Integer.parseInt(InputParser.getOptionValue(commandLine, CmdOption.NUM_THREADS));
    if (!InputValidator.isComputationNumberValid(numThreads)) {
      throw new IllegalArgumentException("Precision  is not valid");
    }
    return numThreads;
  }

  /**
   * Parses precision to calculate the Euler number
   * 
   * @param commandLine - command line arguments
   * @return precision digits to cmpute the Euler number
   */
  public static int parsePrecision(CommandLine commandLine) {

    int precision = Integer.parseInt(InputParser.getOptionValue(commandLine, CmdOption.PRECISION));
    if (!InputValidator.isComputationNumberValid(precision)) {
      throw new IllegalArgumentException("Precision  is not valid");
    }
    return precision;
  }

  /**
   * Parses the number of repetitions for the computation to be repeated
   * 
   * @param commandLine - command line arguments
   * @return total repetitions of a computation
   */
  public static int parseRepetitions(CommandLine commandLine) {
    int repetitions =
        Integer.parseInt(InputParser.getOptionValue(commandLine, CmdOption.REPETITIONS));
    if (!InputValidator.isComputationNumberValid(repetitions)) {
      throw new IllegalArgumentException("Repetitions  is not valid");
    }
    return repetitions;
  }

  /**
   * Parses username
   * 
   * @param commandLine - command line arguments
   * @return username of a client
   */
  public static String parseUsername(CommandLine commandLine) {
    String username = InputParser.getOptionValue(commandLine, CmdOption.USER_NAME);
    if (!InputValidator.isUsernameValid(username)) {
      throw new IllegalArgumentException("Email  is not valid");
    }
    return username;
  }

  /**
   * Parses user email
   * 
   * @param commandLine - command line arguments
   * @return user email
   */
  public static String parseEmail(CommandLine commandLine) {
    String email = InputParser.getOptionValue(commandLine, CmdOption.EMAIL);
    InputParser.getOptionValue(commandLine, CmdOption.EMAIL);
    if (!InputValidator.isValidEmailAddress(email)) {
      throw new IllegalArgumentException("Email  is not valid");
    }
    return email;
  }

  /**
   * Parses user IBAN account id
   * 
   * @param commandLine - command line arguments
   * @return user IBAN
   */
  public static String parseIban(CommandLine commandLine) {
    String iban = InputParser.getOptionValue(commandLine, CmdOption.IBAN);
    if (!InputValidator.isIbanValid(iban)) {
      throw new IllegalArgumentException("IBAN  is not valid");
    }
    return iban;
  }

  /**
   * Parses the user money he bet
   * 
   * @param commandLine - command line arguments
   * @return user money he bet
   */
  public static double parseBetMoney(CommandLine commandLine) {
    double betMoney =
        Double.parseDouble(InputParser.getOptionValue(commandLine, CmdOption.BET_AMOUNT));

    if (!InputValidator.isBetAmountValid(betMoney)) {
      throw new IllegalArgumentException("Bet amount is not valid");
    }
    return betMoney;
  }

  /**
   * Parses user bet choice
   * 
   * @param commandLine - command line arguments
   * @return user bet choice
   */
  public static BetChoice parseBetChoice(CommandLine commandLine) {
    String betChoice = InputParser.getOptionValue(commandLine, CmdOption.CHOICE);
    if (!InputValidator.isBetChoiceValid(betChoice)) {
      throw new IllegalArgumentException("Bet amount is not valid");
    }
    BetChoice userBetChoice = InputConverter.convertStringToBetChoice(betChoice);
    return userBetChoice;
  }
}
