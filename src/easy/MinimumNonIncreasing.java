package easy;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.

 If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.

 Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.



 Example 1:

 Input: nums = [4,3,10,9,8]
 Output: [10,9]
 Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.
 Example 2:

 Input: nums = [4,4,7,6,7]
 Output: [7,7,6]
 Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
 Example 3:

 Input: nums = [6]
 Output: [6]
 */
public class MinimumNonIncreasing {

  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] a1 = { 4,4,7,6,7};
    minSubsequence(a1).stream().map(num -> num + " ").forEach(System.out::print);
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static   List<Integer> minSubsequence(int[] nums)  {
    Arrays.sort(nums);
    List<Integer> result = new ArrayList<>();

    for (int i = nums.length - 1; i >= 0 ; i = i - 1) {
      int cnt1 = 0;
      int cnt2 = 0;
      for (int j = nums.length - 1 ; j >= i ; j--) {
        cnt1= cnt1 + nums[j];

      }
      for (int j = i-1 ; j >= 0 ; j--) {
        cnt2= cnt2 + nums[j];

      }
      if (cnt1 > cnt2) {
        System.out.println(cnt1);
        System.out.println(cnt2);
        for (int j = nums.length - 1 ; j >= i ; j--) {
          result.add( nums[j]);

        }
        break;
      }

    }
    return result;
  }
}
