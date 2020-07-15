package app.modes;

import bet.options.GameOption;

/*
 * Available compute modes for calculating euler number
 */
public enum ComputeMode implements GameOption {
  PARALLEL("parallel"), SELF("self"), SINGLE("single"), SHARED("shared");


  private String name;

  /**
   * Creates compute mode
   * 
   * @param name
   */
  ComputeMode(String name) {
    this.name = name;
  }


  /**
   * Retrieves compute mode name/value
   * 
   * @return compute mode name/value
   */
  @Override
  public String getValue() {
    return name;
  }

}
