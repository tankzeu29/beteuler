package bet;

/*
 * Options to calculate a bet
 */
public class BetOptions {

  private String calculateMode;
  private String factMode;
  private int totalThreads;
  private int precision;


  private int repeptitions;
  private String fileResultPath;

  /**
   * Create bet options for a bet
   * 
   * @param calculateMode - a way the bet to be calculated
   * @param factMode - factorial mode to be used for calculation
   * @param totalThreads - total threads to be used
   * @param precision - precision after the decimal point to be used
   * @param repetitions - total repetitions of the calculation
   * @param fileResultPath - destination path where the file result to be saved
   */
  public BetOptions(String calculateMode, String factMode, int totalThreads, int precision,
      int repetitions, String fileResultPath) {
    this.calculateMode = calculateMode;
    this.factMode = factMode;
    this.totalThreads = totalThreads;
    this.precision = precision;
    this.repeptitions = repetitions;
    this.fileResultPath = fileResultPath;

  }

  /**
   * Retrieve the calculate mode
   * 
   * @return calculate mode
   */
  public String getCalculateMode() {
    return calculateMode;
  }


  /**
   * Retrieve factorial mode to be used
   * 
   * @return factorial mode
   */
  public String getFactMode() {
    return factMode;
  }


  /**
   * Total threads to be used for calculation
   * 
   * @return threads used for calculation
   */
  public int getTotalThreads() {
    return totalThreads;
  }


  /**
   * Retrieve Precision to be used after the decimal point
   * 
   * @return precision to be used after decimal point
   */
  public int getPrecision() {
    return precision;
  }


  /**
   * Retrieve total repetitions for calculation
   * 
   * @return total repetiions for calculation
   */
  public int getRepeptitions() {
    return repeptitions;
  }



  public String getFileResultPath() {
    return fileResultPath;
  }


}
