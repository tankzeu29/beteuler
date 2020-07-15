package euler.factorial;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents cached factorial strategy
 * 
 * @author Tankz
 *
 */
public class CacheFact implements Factorial {

  private Map<Long, BigInteger> factCache;

  /**
   * Creates factorial cache with size
   * 
   * @param size - factorial cache size
   */
  private CacheFact(int size) {

    factCache = new HashMap<>();
    initializeCache(size);

  }

  /**
   * Creates factorial cache based on precision
   * 
   * @param precision - precision for Euler numer to be computed
   * @return factorial cache
   */
  public static CacheFact of(int precision) {


    return new CacheFact(2 * precision + 2);
  }


  /**
   * Initializes factorial cache with factorial values by given max bound
   * 
   * @param maxCacheValue - max factorial to be computed
   */
  private void initializeCache(int maxCacheValue) {

    BigInteger result = BigInteger.ONE;
    factCache.put(0l, result);
    factCache.put(1l, result);
    for (long i = 2; i <= maxCacheValue; i += 1) {
      BigInteger currentRes = factCache.get(i - 1).multiply(BigInteger.valueOf(i));

      factCache.put(i, currentRes);
    }
  }

  /**
   * Retrieves factorial by index
   * 
   * @return factorial value by given index
   */
  @Override
  public BigInteger get(long factorialIndex) {

    return factCache.get(factorialIndex);
  }



}
