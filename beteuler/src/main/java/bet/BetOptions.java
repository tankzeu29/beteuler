package bet;

public class BetOptions {

  private String mode;
  private String factMode;
  private int numThreads;
  private int precision;


  private int repeptitions;
  private String outputPath;

  public BetOptions(String mode, String factMode, int numThreads, int precision, int repetitions,
      String outputPath) {
    this.mode = mode;
    this.factMode = factMode;
    this.numThreads = numThreads;
    this.precision = precision;
    this.repeptitions = repetitions;
    this.outputPath = outputPath;

  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public String getFactMode() {
    return factMode;
  }

  public void setFactMode(String factMode) {
    this.factMode = factMode;
  }

  public int getNumThreads() {
    return numThreads;
  }

  public void setNumThreads(int numThreads) {
    this.numThreads = numThreads;
  }

  public int getPrecision() {
    return precision;
  }

  public void setPrecision(int precision) {
    this.precision = precision;
  }

  public int getRepeptitions() {
    return repeptitions;
  }

  public void setRepeptitions(int repeptitions) {
    this.repeptitions = repeptitions;
  }

  public String getOutputPath() {
    return outputPath;
  }

  public void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }
}
