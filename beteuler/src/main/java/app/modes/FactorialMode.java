package app.modes;

import bet.options.GameOption;

public enum FactorialMode implements GameOption {

  CACHED("cached"), DC("dc");
  private String name;

  FactorialMode(String name) {
    this.name = name;
  }


  @Override
  public String getValue() {
    return name;
  }
}
