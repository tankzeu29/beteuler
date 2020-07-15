
package euler.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import app.logging.ApplicationLogger;
import euler.factorial.Factorial;


/**
 * Thread to compute part of the euler number
 * 
 * @author Tankz
 *
 */
public class EulerThread extends Thread {
  private int threadIndex;
  private int numberOfThreads;
  private int precision;
  private int totalSymbols;
  private BigDecimal result = BigDecimal.ZERO;
  public Factorial factorialSupplier;

  /**
   * Custom thread to compute part of the euler number
   * 
   * @param index - index of the thread
   * @param numThreads - total threads participating with the thread
   * @param totalIterations - total iterations to be executed
   * @param totalSymbols - total symbols to compute
   * @param factorialSupplier - way to calculate the factorial
   */
  public EulerThread(int index, int numThreads, int totalIterations, int totalSymbols,
      Factorial factorialSupplier) {
    super();
    this.threadIndex = index;
    this.numberOfThreads = numThreads;
    this.precision = totalIterations;
    this.factorialSupplier = factorialSupplier;
    this.totalSymbols = totalSymbols;
  }

  /**
   * Retrieves the thread computed result
   * 
   * @return part of euler number result
   */
  public BigDecimal getResult() {
    return result;
  }

  /**
   * Compute euler fractions based on the thread index
   * 
   */
  @Override
  public void run() {


    BigDecimal curentResult = BigDecimal.ZERO;
    for (int threadModulo = 0;; threadModulo++) {

      if (threadModulo % numberOfThreads != threadIndex) {

        continue;
      }

      if (threadModulo <= precision - 2) {


        BigDecimal dominator = new BigDecimal((2 * threadModulo) + 1);
        BigDecimal enumerator;
        try {
          enumerator = new BigDecimal(factorialSupplier.get(2 * threadModulo));
        } catch (Exception e) {

          ApplicationLogger.getLogger().log(Level.SEVERE, "Failed to parse parameters", e);
          break;
        }
        curentResult = dominator.divide(enumerator, totalSymbols, RoundingMode.HALF_DOWN);

        result = result.add(curentResult);

      } else {

        break;
      }

    }



  }



}
