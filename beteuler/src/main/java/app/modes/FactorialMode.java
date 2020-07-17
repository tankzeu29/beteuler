package app.modes;

import bet.options.GameOption;

/*
 * Possible modes to calculate factorial
 */
public enum FactorialMode implements GameOption {

  CACHED("cached"), DC("dc");
  private String name;

  /**
   * Create factorial mode
   * 
   * @param name - name of the factorial mode
   */
  FactorialMode(String name) {
    this.name = name;
  }

  /**
   * Retrieves the factorial mode name
   * 
   * @return retrieves the factorial mode name
   */
  @Override
  public String getValue() {
    return name;
  }
}
