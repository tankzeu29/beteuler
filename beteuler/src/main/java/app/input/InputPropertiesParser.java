package app.input;

import org.apache.commons.cli.CommandLine;
import app.modes.ComputeMode;
import bet.options.BetChoice;

public class InputPropertiesParser {

  private InputPropertiesParser() {

  }

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

  public static String parseFactorialMode(CommandLine commandLine) {



    String factorialMode = InputParser.getOptionValue(commandLine, CmdOption.FACT_MODE);

    if (!InputValidator.isFactorialModeValid(factorialMode)) {
      throw new IllegalArgumentException("Output path  is not valid");
    }
    return factorialMode;
  }

  public static int parseThreadsNumber(CommandLine commandLine, String mode) {
    int numThreads = ComputeMode.SINGLE.getValue().equals(mode) ? 1
        : Integer.parseInt(InputParser.getOptionValue(commandLine, CmdOption.NUM_THREADS));
    if (!InputValidator.isComputationNumberValid(numThreads)) {
      throw new IllegalArgumentException("Precision  is not valid");
    }
    return numThreads;
  }


  public static int parsePrecision(CommandLine commandLine) {

    int precision = Integer.parseInt(InputParser.getOptionValue(commandLine, CmdOption.PRECISION));
    if (!InputValidator.isComputationNumberValid(precision)) {
      throw new IllegalArgumentException("Precision  is not valid");
    }
    return precision;
  }

  public static int parseRepetitions(CommandLine commandLine) {
    int repetitions =
        Integer.parseInt(InputParser.getOptionValue(commandLine, CmdOption.REPETITIONS));
    if (!InputValidator.isComputationNumberValid(repetitions)) {
      throw new IllegalArgumentException("Repetitions  is not valid");
    }
    return repetitions;
  }

  public static String parseUsername(CommandLine commandLine) {
    String username = InputParser.getOptionValue(commandLine, CmdOption.USER_NAME);
    if (!InputValidator.isUsernameValid(username)) {
      throw new IllegalArgumentException("Email  is not valid");
    }
    return username;
  }

  public static String parseEmail(CommandLine commandLine) {
    String email = InputParser.getOptionValue(commandLine, CmdOption.EMAIL);
    InputParser.getOptionValue(commandLine, CmdOption.EMAIL);
    if (!InputValidator.isValidEmailAddress(email)) {
      throw new IllegalArgumentException("Email  is not valid");
    }
    return email;
  }

  public static String parseIban(CommandLine commandLine) {
    String iban = InputParser.getOptionValue(commandLine, CmdOption.IBAN);
    if (!InputValidator.isIbanValid(iban)) {
      throw new IllegalArgumentException("IBAN  is not valid");
    }
    return iban;
  }

  public static double parseBetMoney(CommandLine commandLine) {
    double betMoney =
        Double.parseDouble(InputParser.getOptionValue(commandLine, CmdOption.BET_AMOUNT));

    if (!InputValidator.isBetAmountValid(betMoney)) {
      throw new IllegalArgumentException("Bet amount is not valid");
    }
    return betMoney;
  }

  public static BetChoice parseBetChoice(CommandLine commandLine) {
    String betChoice = InputParser.getOptionValue(commandLine, CmdOption.CHOICE);
    if (!InputValidator.isBetChoiceValid(betChoice)) {
      throw new IllegalArgumentException("Bet amount is not valid");
    }
    BetChoice userBetChoice = InputConverter.convertStringToBetChoice(betChoice);
    return userBetChoice;
  }
}
