package medium;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 5413. Rearrange Words in a Sentence
 *Given a sentence text (A sentence is a string of space-separated words) in the following format:
 *
 * First letter is in upper case.
 * Each word in text are separated by a single space.
 * Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.
 *
 * Return the new text following the format shown above.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "Leetcode is cool"
 * Output: "Is cool leetcode"
 * Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
 * Output is ordered by length and the new first word starts with capital letter.
 * Example 2:
 *
 * Input: text = "Keep calm and code on"
 * Output: "On and keep calm code"
 * Explanation: Output is ordered as follows:
 * "On" 2 letters.
 * "and" 3 letters.
 * "keep" 4 letters in case of tie order by position in original text.
 * "calm" 4 letters.
 * "code" 4 letters.
 * Example 3:
 *
 * Input: text = "To be or not to be"
 * Output: "To be or to be not"
 *
 *
 * Constraints:
 *
 * text begins with a capital letter and then contains lowercase letters and single space between words.
 * 1 <= text.length <= 10^5
 */
public class RearrangeWordsSentence {

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(arrangeWords("Leetcode is cool"));
    System.out.println(arrangeWords("Keep calm and code on"));
    System.out.println(arrangeWords("To be or not to be"));
    System.out.println(arrangeWords("Jtik hrzrvhbmk gbo cfhmiqwonj ojkew ufvledv bomoeqt ops jgi zdhvbpbb zczmepdfpm jry rjazc titttcu"));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }
  public static String arrangeWords(String text) {
    List<String> result = new ArrayList<>();
    String[] s = text.toLowerCase().split(" ");
    for (int i = 0; i < s.length; i++) {
      result.add(s[i] + "_" + (i));
    }
    String collect = result.stream().sorted((o1, o2) -> {
      String[] s1 = o1.split("_");
      String[] s2 = o2.split("_");
      if (s1[0].length() > s2[0].length()) {
        return 1;
      } else if (s1[0].length() < s2[0].length()) {
        return -1;
      } else {
        if (Integer.parseInt(s1[1]) > Integer.parseInt(s2[1])) {
          return 1;
        } else {
          return -1;
        }
      }

    }).map(o1 -> o1.split("_")[0]).collect(Collectors.joining(" "));
    return collect.substring(0,1).toUpperCase() + collect.substring(1);
  }
}
