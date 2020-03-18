package easy;

import java.time.Duration;
import java.time.Instant;

public class ReduceNumber {

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(numberOfSteps(1231234222));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");
    System.out.println(Duration.between(start, end).toMillis());

  }

  public static int numberOfSteps (int num) {
    if (num <= 0) {
      return 0;
    }
    if (num % 2 == 0) {
      return numberOfSteps(num / 2) + 1;
    } else {
      return numberOfSteps(num - 1) + 1;
    }
  }
}
