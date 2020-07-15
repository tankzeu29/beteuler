
package euler.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import euler.factorial.Factorial;

public class EulerThread extends Thread {
  private int threadIndex;
  private int numberOfThreads;
  private int precision;
  private int totalSymbols;
  private BigDecimal result = BigDecimal.ZERO;
  public Factorial factorialSupplier;


  public EulerThread(int index, int numThreads, int totalIterations, int totalSymbols,
      Factorial factorialSupplier) {
    super();
    this.threadIndex = index;
    this.numberOfThreads = numThreads;
    this.precision = totalIterations;
    this.factorialSupplier = factorialSupplier;
    this.totalSymbols = totalSymbols;
  }


  public BigDecimal getResult() {
    return result;
  }

  @Override
  public void run() {


    BigDecimal curentResult = BigDecimal.ZERO;
    for (int threadModulo = 0;; threadModulo++) {

      if (threadModulo % numberOfThreads != threadIndex) {

        continue;
      }

      if (threadModulo <= precision - 2) {


        BigDecimal dominator = new BigDecimal((2 * threadModulo) + 1);
        BigDecimal enumerator = new BigDecimal(factorialSupplier.get(2 * threadModulo));
        curentResult = dominator.divide(enumerator, totalSymbols, RoundingMode.HALF_DOWN);

        result = result.add(curentResult);

      } else {

        break;
      }

    }



  }



}
