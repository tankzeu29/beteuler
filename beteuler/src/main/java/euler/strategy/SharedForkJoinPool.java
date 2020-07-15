package euler.strategy;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;


public class SharedForkJoinPool {

  // 1 map is needed only
  private static Map<Integer, CustomForkPool> pools;

  public synchronized static ExecutorService get(final int totalThreads) {
    if (pools == null) {
      pools = new HashMap<>();
      pools.putIfAbsent(totalThreads, new CustomForkPool(totalThreads));
    }

    return pools.get(totalThreads).executorService;
  }

  private static class CustomForkPool {
    ExecutorService executorService;

    public CustomForkPool(int numThreads) {
      executorService = new ForkJoinPool(numThreads);
    }
  }
}
