package easy;

import java.time.Duration;
import java.time.Instant;

/**
 * 5396. Consecutive Characters
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Return the power of the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 */
public class ConsecutiveCharacters {

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(maxPower("tourist"));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");
    System.out.println(Duration.between(start, end).toMillis());

  }

  public static int maxPower(String s) {
    int cnt = 1, max = 1;
    for (int i = 1; i < s.toCharArray().length; i++) {
      if (s.charAt(i) == s.charAt(i-1)) {
        cnt ++;
      } else {
        cnt = 1;
      }
      if (max < cnt) {
        max = cnt;
      }

    }
    return max;
  }
}
