package medium;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * 5397. Simplified Fractions
 *Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive) such that the denominator is less-than-or-equal-to n. The fractions can be in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: ["1/2"]
 * Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.
 * Example 2:
 *
 * Input: n = 3
 * Output: ["1/2","1/3","2/3"]
 * Example 3:
 *
 * Input: n = 4
 * Output: ["1/2","1/3","1/4","2/3","3/4"]
 * Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2".
 * Example 4:
 *
 * Input: n = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= n <= 100
 */
public class SimplifiedFractions {

  public static void main(String[] args) {
    Instant start = Instant.now();
//    System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
    simplifiedFractions(6).forEach(System.out::println);
//    System.out.println(numSteps2("1101"));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static List<String> simplifiedFractions(int n) {
    List<String> result = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
        for  (int j = 1; j < i ; j++) {
          if (isV(j, i) || j == 1) {
            result.add(j +"/"+ i);
          }

        }
      }
      return result;
  }
  public static boolean isV(int n1, int n2) {
    for (int i = 2 ; i <= n1 ; i++) {
      if (n1 % i == 0 && n2 % i == 0) {
        return false;
      }
    }
    return true;
  }
}
