package medium;

import java.time.Duration;
import java.time.Instant;

/**
 * 5417. Maximum Number of Vowels in a Substring of Given Length
 Given a string s and an integer k.

 Return the maximum number of vowel letters in any substring of s with length k.

 Vowel letters in English are (a, e, i, o, u).



 Example 1:

 Input: s = "abciiidef", k = 3
 Output: 3
 Explanation: The substring "iii" contains 3 vowel letters.
 Example 2:

 Input: s = "aeiou", k = 2
 Output: 2
 Explanation: Any substring of length 2 contains 2 vowels.
 Example 3:

 Input: s = "leetcode", k = 3
 Output: 2
 Explanation: "lee", "eet" and "ode" contain 2 vowels.
 Example 4:

 Input: s = "rhythms", k = 4
 Output: 0
 Explanation: We can see that s doesn't have any vowel letters.
 Example 5:

 Input: s = "tryhard", k = 4
 Output: 1


 Constraints:

 1 <= s.length <= 10^5
 s consists of lowercase English letters.
 1 <= k <= s.length

 */
public class MaximumNumberofVowels {

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(maxVowelsBetter("abciiidef",3));
    System.out.println(maxVowelsBetter("aeiou",2));
    System.out.println(maxVowelsBetter("leetcode",3));
    System.out.println(maxVowelsBetter("rhythms",4));
    System.out.println(maxVowelsBetter("tryhard",4));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  /**
   */
  public static int maxVowels(String s, int k) {
    char[] vowelAry = {'a', 'e', 'i', 'o', 'u'};
    char[] chars = s.toCharArray();
    boolean[] isvowelAry = new boolean[chars.length];
    for (int i = 0; i < chars.length; i++) {
      for (char c : vowelAry) {
        if (chars[i] == c) {
          isvowelAry[i] = true;
          break;
        }
      }
    }
    int result = 0,temp ;
    for (int i = 0; i < isvowelAry.length; i++) {
      temp = 0;
      for (int j = i; j < i + k && j < chars.length; j++) {
        if (isvowelAry[j]) {
          temp ++;
        }
      }


      if (temp == k) {
        return k;
      }
      if (result < temp) {
        result = temp;
      }

    }
    return result;
  }
  public static int maxVowelsBetter(String s, int k) {
    char[] vowelAry = {'a', 'e', 'i', 'o', 'u'};
    char[] chars = s.toCharArray();
    boolean[] isvowelAry = new boolean[chars.length];
    for (int i = 0; i < chars.length; i++) {
      for (char c : vowelAry) {
        if (chars[i] == c) {
          isvowelAry[i] = true;
          break;
        }
      }
    }
    int left = 0, length =0, temp = 0, result = 0,index = 0;
    while (index < isvowelAry.length) {
      if (isvowelAry[index]) {
        temp ++;
      }
      index ++;
      length ++ ;
      if (temp == k) {
        return k;
      } else if (length == k){
        if (result < temp) {
          result = temp;
        }

        if (isvowelAry[left]) {
          temp = temp -1;
        }
        left ++;
        length --;
      }
    }

    return result;
  }
}
