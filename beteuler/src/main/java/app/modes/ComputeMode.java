package app.modes;

import bet.options.GameOption;

public enum ComputeMode implements GameOption {
  PARALLEL("parallel"), SELF("self"), SINGLE("single"), SHARED("shared");


  private String name;

  ComputeMode(String name) {
    this.name = name;
  }



  @Override
  public String getValue() {
    return name;
  }

}
