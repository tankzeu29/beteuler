package app.input;

import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;
import app.modes.ComputeMode;
import app.modes.FactorialMode;
import bet.options.BetChoice;

public class InputValidator {
  private static final String USERNAME_REGEX = "[A-Za-z0-9_]+";

  private InputValidator() {

  }

  public static boolean isStringEmpty(String property) {
    return property == null || property.trim().isEmpty();
  }

  public static boolean isIbanValid(String iban) {


    if (isStringEmpty(iban)) {
      return false;
    }

    IBANCheckDigit ibanValidator = new IBANCheckDigit();

    return ibanValidator.isValid(iban);



  }

  public static boolean isValidEmailAddress(String email) {
    if (isStringEmpty(email)) {
      return false;
    }

    return EmailValidator.getInstance().isValid(email);
  }


  public static boolean isUsernameValid(String username) {
    if (isStringEmpty(username)) {
      return false;
    }

    Pattern pattern = Pattern.compile(USERNAME_REGEX);
    return (username != null) && pattern.matcher(username).matches();
  }

  public static boolean isBetAmountValid(double amount) {

    return amount > 0.0;
  }

  public static boolean isOutputPathValid(String outputPath) {

    return !isStringEmpty(outputPath);


  }

  public static boolean isComputationNumberValid(int computationNumber) {

    return computationNumber > 0;

  }

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
