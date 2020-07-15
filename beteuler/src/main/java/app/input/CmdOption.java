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

  private String key;
  private String value;

  CmdOption(String key, String value) {
    this.key = key;
    this.value = value;
  }

  /*
   * Retrieves option key return key - key that matches console input key
   */

  public String getKey() {
    return key;
  }

  /*
   * Retrieves option key return key - key that matches console input key
   */
  @Override
  public String getValue() {
    return value;
  }

}
