package euler.timer;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.google.common.base.Stopwatch;


/**
 * Timer class to compute the time elapsed to compute a Runnable
 * 
 * @author Tankz
 *
 */
public class Timer {
  private Runnable runnable;
  private int numRep;

  /**
   * creates Timer with total repetitions and task to execute
   * 
   * @param numRep - total repetitions
   * @param runnable - task to execute
   */
  public Timer(int numRep, Runnable runnable) {
    this.numRep = numRep;
    this.runnable = runnable;

  }

  /**
   * Computes the total time it took to compute a task
   * 
   * @return total time elapsed a task to finish
   */
  public List<Long> time() {
    return IntStream.range(0, numRep).mapToLong(i -> {
      Stopwatch stopwatch = new Stopwatch();
      stopwatch.start();

      runnable.run();
      stopwatch.stop();
      long time = (long) (stopwatch.elapsedTime(TimeUnit.NANOSECONDS) * 1e-6);

      return time;
    }).boxed().collect(Collectors.toList());
  }
}
