package easy;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 *
 * Return the decompressed list.
 *
 *[1, 2, 3, 4] as your input
 * Then, it means
 * "one 2, three 4's" -> [2, 4, 4, 4]
 * a better example is-
 * e.g. [9,1]->[1,1,1,1,1,1,1,1,1]
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 * Example 2:
 *
 * Input: nums = [1,1,2,3]
 * Output: [1,3,3]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class EncodedList {

  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] a1 = { 6,5,4,8};
    Arrays.stream(decompressRLElist(a1)).mapToObj(num -> num + " ").forEach(System.out::print);
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static  int[] decompressRLElist(int[] nums)  {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i = i + 2) {
      for (int j = 0 ; j < nums[i] ; j++) {
        result.add(nums[i+1]);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
