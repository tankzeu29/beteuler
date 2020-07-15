package euler.factorial;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CacheFact implements Factorial {

  private Map<Long, BigInteger> factCache;

  private CacheFact(int k) {

    factCache = new HashMap<>();
    createCache(k);

  }

  public static CacheFact of(int precision) {


    return new CacheFact(2 * precision + 2);
  }


  private void createCache(int maxCacheValue) {

    BigInteger result = BigInteger.ONE;
    factCache.put(0l, result);
    factCache.put(1l, result);
    for (long i = 2; i <= maxCacheValue; i += 1) {
      BigInteger currentRes = factCache.get(i - 1).multiply(BigInteger.valueOf(i));

      factCache.put(i, currentRes);
    }
  }

  @Override
  public BigInteger get(long k) {

    return factCache.get(k);
  }



}
