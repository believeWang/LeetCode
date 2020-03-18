package easy;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class PerfectNumber {
  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(checkPerfectNumber(28));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");
    System.out.println(Duration.between(start, end).toMillis());

  }

   private static boolean checkPerfectNumber(int num) {
    if (num % 2 != 0 || num == 0) return false;
    List<Integer> divisors = getDivisors(num);
    return divisors.stream().mapToInt(i -> i).sum() == num;

  }

  private static List<Integer> getDivisors(int num) {
    List<Integer> result = new ArrayList<>();
    for(int i = 1; i <= num/2 ; i++) {
      if (num % i == 0) result.add(i);
    }

    return result;
  }
}
