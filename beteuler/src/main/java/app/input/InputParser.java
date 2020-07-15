package app.input;

import java.util.Optional;
import java.util.logging.Level;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import app.logging.ApplicationLogger;

/*
 * Parses player input from the console
 */
public class InputParser {

  /*
   * Private constructor to prevent creation
   */
  public InputParser() {

  }

  /**
   * Returns player options from the command line
   *
   * @return all available option to pass from the console
   */
  public static Options getOptions() {
    Options options = new Options();
    options.addOption(CmdOption.MODE.getKey(), true, "Execution Mode");
    options.addOption(CmdOption.NUM_THREADS.getKey(), true, "Total threads");
    options.addOption(CmdOption.PRECISION.getKey(), true, "Precision after decimal point");



    options.addOption(CmdOption.OUTPUT.getKey(), true, "path to output file");

    options.addOption(CmdOption.FACT_MODE.getKey(), true, "way to calculate the factorials");
    options.addOption(CmdOption.USER_NAME.getKey(), true, "username of the client");
    options.addOption(CmdOption.EMAIL.getKey(), true, "email of the client");
    options.addOption(CmdOption.BET_AMOUNT.getKey(), true, "way to calculate the factorials");
    options.addOption(CmdOption.IBAN.getKey(), true, "way to calculate the factorials");

    options.addOption(CmdOption.CHOICE.getKey(), true, "way to calculate the factorials");

    return options;
  }

  /**
   * Returns an Image object that can then be painted on the screen. The url argument must specify
   * 
   * @param commandLine - command line
   * @param optionCode - command option
   * @return the image at the specified URL
   */
  public static boolean isOptionAvailable(CommandLine commandLine, CmdOption optionCode) {
    return commandLine.hasOption(optionCode.getKey());
  }

  /**
   * Retrieves value for a command line parameter
   * 
   * @param commandLine - command line
   * @param optionCode - command option
   * @return value of a command line option
   */
  public static String getOptionValue(CommandLine commandLine, CmdOption optionCode) {
    return commandLine.getOptionValue(optionCode.getKey(), optionCode.getValue());
  }

  /**
   * Converts command line arguments to object represeting the arguments
   * 
   * @param args - command line arguments
   * @return command line object representing the player input
   */
  public static Optional<CommandLine> parseCommandLine(String[] args) {
    Options options = InputParser.getOptions();
    CommandLineParser parser = new DefaultParser();
    try {
      return Optional.of(parser.parse(options, args));
    } catch (ParseException e) {
      ApplicationLogger.getLogger().log(Level.SEVERE, "Failed create optional parser", e);
    }

    return Optional.empty();
  }

}
