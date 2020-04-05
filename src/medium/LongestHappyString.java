package medium;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

 Given three integers a, b and c, return any string s, which satisfies following conditions:

 s is happy and longest possible.
 s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 s will only contain 'a', 'b' and 'c' letters.
 If there is no such string s return the empty string "".
 Example 1:

 Input: a = 1, b = 1, c = 7
 Output: "ccaccbcc"
 Explanation: "ccbccacc" would also be a correct answer.
 Example 2:

 Input: a = 2, b = 2, c = 1
 Output: "aabbc"
 Example 3:

 Input: a = 7, b = 1, c = 0
 Output: "aabaa"
 Explanation: It's the only correct answer in this case.

 Input: a = 4, b = 4, c = 3
 Output: ""aabbccaabbc""
 Input: a = 5, b = 4, c = 3
 Output: "aabbaaccbbac"

 */
public class LongestHappyString {

  public static void main(String[] args) {
    Instant start = Instant.now();
    System.out.println(longestDiverseString(7,1,0)); //aabaa
    System.out.println(longestDiverseString(1,1,7)); //ccaccbcc
    System.out.println(longestDiverseString(2,2,1)); //aabbc
    System.out.println(longestDiverseString(4,4,3)); //aabbccaabbc
    System.out.println(longestDiverseString(5,4,3)); //aabbaaccbbac
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  /**
   * 邏輯是 每次都最優先放入目前還剩下最多次數的， 放的時候不能跟前面兩個重複，如果在次數都用完之前都沒辦法再放入，就結束
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static String longestDiverseString(int a, int b, int c) {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", a);
    map.put("b", b);
    map.put("c", c);
    List<String> orders = Arrays.asList("a", "b", "c");
    String result = "";
    while(map.get("a") + map.get("b") + map.get("c") > 0) {
      boolean isDone = false; //判斷這次有沒有做事情  如果abc跑過 結果都不能再增加 代表結束
      //每次都重新排序 找到最大的
      orders.sort((o1,o2) -> {
        if (map.get(o1) > map.get(o2)) {
          return -1;
        } else if (map.get(o1) < map.get(o2)) {
          return 1;
        }
        return 0;
      }) ;
      for (int i = 0; i < orders.size(); i++) {
        String s = orders.get(i);
        if (map.get(s) == 0) continue; //如果已經沒了就跳下一個
        if (result.length() < 2 ||
            !(result.charAt(result.length() - 1) == result.charAt(result.length() - 2)
                && result.charAt(result.length() - 1) == s.charAt(0))) {
          result = result + s;
          map.put(s, map.get(s) - 1);
          isDone = false;
          break; // 找到一個就跳  重新找最大的
        }
        isDone = true;
      }
      if (isDone) {
        break;
      }
    }
    return result;
  }
}
