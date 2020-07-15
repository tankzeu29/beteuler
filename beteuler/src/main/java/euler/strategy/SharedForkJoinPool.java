package euler.strategy;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

/**
 * ShareForkJoinPool to compute euler number
 * 
 * @author Tankz
 *
 */

public class SharedForkJoinPool {

  // 1 map is needed only
  private static Map<Integer, CustomForkPool> pools;

  /**
   * Retrieves forkJoinedPool
   * 
   * @param totalThreads - total threads to create ForkJoinPool
   * @return SharedForkJoin pool
   */
  public synchronized static ExecutorService get(final int totalThreads) {
    if (pools == null) {
      pools = new HashMap<>();
      pools.putIfAbsent(totalThreads, new CustomForkPool(totalThreads));
    }

    return pools.get(totalThreads).executorService;
  }

  /**
   * Custom fork join pool class
   * 
   * @author Tankz
   *
   */
  private static class CustomForkPool {
    ExecutorService executorService;

    /**
     * Initializes ForkJoinPool with certain amount of threads
     * 
     * @param numThreads - total threads to be used in the ForkJoinedPool
     */
    public CustomForkPool(int numThreads) {
      executorService = new ForkJoinPool(numThreads);
    }
  }
}
