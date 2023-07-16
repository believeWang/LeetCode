package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class TwoSum {

  public static void main(String[] args) {

  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> result = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      int num = target - nums[i];
      if (result.containsKey(num)) {
        return new int[]{result.get(num), i};
      }

      result.put(num, i);

    }
    throw new IllegalArgumentException("no correct answer");

  }
}
