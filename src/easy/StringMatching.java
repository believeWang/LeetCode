package easy;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of string words. Return all strings in words which is substring of another word in any order.
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 *
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 *
 * Input: words = ["blue","green","bu"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 */
public class StringMatching {

  public static void main(String[] args) {
    Instant start = Instant.now();
    String[] a1 = {"leetcoder","leetcode","od","hamlet","am"};
    stringMatching( a1).stream().map(num -> num + " ").forEach(System.out::print);
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static List<String> stringMatching(String[] words) {
    Set<String> result = new HashSet<>();
    for (String subWord : words) {
      for (String longWord : words) {
        if (subWord.equals( longWord) || longWord.length() < subWord.length()) {
          continue;
        }
        if (longWord.contains(subWord)) {
          result.add(subWord);
        }
      }
    }

    return new ArrayList<>(result);
  }
}
