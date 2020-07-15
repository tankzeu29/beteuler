package app.input;

import bet.options.GameOption;

/*
 * Input options from the console
 */
public enum CmdOption implements GameOption {
  MODE("mode", "parallel"), NUM_THREADS("t",
      String.valueOf(Runtime.getRuntime().availableProcessors())), PRECISION("p", "2"), OUTPUT(
          "output", "./eulerResult.tmp"), FACT_MODE("fact_mode", "cached"), USER_NAME("username",
              ""), IBAN("iban", ""), BET_AMOUNT("amount", "0"), EMAIL("email",
                  "empty@abv.bg"), CHOICE("bet_choice", "OVER"), REPETITIONS("repetitions", "1");

  /**
   * property key
   */
  private String key;
  /**
   * property value
   */
  private String value;

  /**
   * Constructor with command line option key and value
   * 
   * @param key - key of parameter
   * @param value - value of parameter
   */
  CmdOption(String key, String value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Retrievs parameter key name
   * 
   * 
   * @return the key name of a parameter
   */
  public String getKey() {
    return key;
  }

  /**
   * Retrieves parameter value
   * 
   * @return parameter value
   */
  @Override
  public String getValue() {
    return value;
  }

}
