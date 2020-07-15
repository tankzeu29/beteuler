package app.input;

import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;
import app.modes.ComputeMode;
import app.modes.FactorialMode;
import bet.options.BetChoice;

/**
 * Validate input parameter values received from external source
 */
public class InputValidator {
  /**
   * Matches valid username
   */
  private static final String USERNAME_REGEX = "[A-Za-z0-9_]+";

  /**
   * Prevent from creating an instance
   */
  private InputValidator() {

  }

  /**
   * Checks if property is empty
   * 
   * @param property - property to be validated if it's empty
   * @return true if the property is null or empty string , else false
   */
  public static boolean isStringEmpty(String property) {
    return property == null || property.trim().isEmpty();
  }

  /**
   * Validates if IBAN is valid
   * 
   * @param iban - number representing credit card identity
   * @return true if the IBAN is valid , else false
   */
  public static boolean isIbanValid(String iban) {


    if (isStringEmpty(iban)) {
      return false;
    }

    IBANCheckDigit ibanValidator = new IBANCheckDigit();

    return ibanValidator.isValid(iban);



  }

  /**
   * Validate user email
   * 
   * @param email - email to be validated
   * @return true if the email is valid , else false
   */
  public static boolean isValidEmailAddress(String email) {
    if (isStringEmpty(email)) {
      return false;
    }

    return EmailValidator.getInstance().isValid(email);
  }

  /**
   * Validate if username is valid
   * 
   * @param username - username to be validated
   * @return true if the username is valid , else false
   */
  public static boolean isUsernameValid(String username) {
    if (isStringEmpty(username)) {
      return false;
    }

    Pattern pattern = Pattern.compile(USERNAME_REGEX);
    return (username != null) && pattern.matcher(username).matches();
  }

  /**
   * Validates if bet amount is greater than zero
   * 
   * @param amount - bet amount
   * @return true if the amount is greater than zero , else false
   */
  public static boolean isBetAmountValid(double amount) {

    return amount > 0.0;
  }

  /**
   * Validates if output path to write is valid
   * 
   * @param outputPath - path representing output file
   * @return true if the the path is not empty, else false.
   */
  public static boolean isOutputPathValid(String outputPath) {

    return !isStringEmpty(outputPath);


  }

  /**
   * Validates if computation number is greater than zero
   * 
   * @param computationNumber - number that will be used for computation
   * @return true if it is greater than zero , else false
   */
  public static boolean isComputationNumberValid(int computationNumber) {

    return computationNumber > 0;

  }

  /**
   * Validates if the computation mode used is available
   * 
   * @param computationMode - mode to compute the Euler number
   * @return true if the mode exists , else false.
   */
  public static boolean isComputationModeValid(String computationMode) {

    if (isStringEmpty(computationMode)) {
      return false;
    }
    boolean isComputationModeValid = false;
    for (ComputeMode mode : ComputeMode.values()) {
      if (mode.getValue().equals(computationMode)) {
        isComputationModeValid = true;
        break;
      }
    }
    return isComputationModeValid;
  }

  /**
   * Validates if the factorial mode used is available
   * 
   * @param factorialMode - mode to compute the Euler number
   * @return true if the mode exists , else false.
   */
  public static boolean isFactorialModeValid(String factorialMode) {

    if (isStringEmpty(factorialMode)) {
      return false;
    }
    boolean isComputationModeValid = false;
    for (FactorialMode mode : FactorialMode.values()) {
      if (mode.getValue().equals(factorialMode)) {
        isComputationModeValid = true;
        break;
      }
    }
    return isComputationModeValid;
  }

  /**
   * Validates if the bet choice mode used is available
   * 
   * @param betChoice - bet choice mode
   * @return true if the mode exists , else false.
   */
  public static boolean isBetChoiceValid(String betChoice) {
    if (isStringEmpty(betChoice)) {
      return false;
    }
    boolean isComputationModeValid = false;
    for (BetChoice mode : BetChoice.values()) {
      if (mode.getValue().equals(betChoice)) {
        isComputationModeValid = true;
        break;
      }
    }
    return isComputationModeValid;
  }



}
