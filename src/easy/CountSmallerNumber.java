package easy;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class CountSmallerNumber {

  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] a1 = { 6,5,4,8};
    Arrays.stream(smallerNumbersThanCurrent2( a1)).mapToObj(num -> num + " ").forEach(System.out::print);
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static int[] smallerNumbersThanCurrent(int[] nums) {
    int[] x; // x is a reference to int[]
    x = new int[nums.length];
    int[][] result;
    result = new int[nums.length][nums.length];
    int cnt = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (i == j) {
          result[i][j] = 0;
          result[j][i] = 0;
        } else if(nums[i] > nums[j]){
          result[i][j] = 1;
          result[j][i] = -1;
        } else if(nums[i] == nums[j]){
          result[i][j] = -1;
          result[j][i] = -1;
        } else {
          result[i][j] = -1;
          result[j][i] = 1;
        }
      } // end of if
      cnt = 0;
      for (int j = 0; j < nums.length; j++) {
        if (result[i][j] == 1) {
          cnt ++;
        }
      } // end of if
      x[i] = cnt;
    } // end of first if


    return x;
  }
  public static int[] smallerNumbersThanCurrent2(int[] nums) {
    int[] count = new int[101];
    int[] res = new int[nums.length];

    for (int i =0; i < nums.length; i++) {
      count[nums[i]]++;
    }
    for (int i = 1 ; i <= 100; i++) {
      System.out.println("i: " + i + " cnt : "+ count[i]);
    }
    for (int i = 1 ; i <= 100; i++) {
      count[i] += count[i-1];
    }
    for (int i = 1 ; i <= 100; i++) {
      System.out.println("i: " + i + " cnt : "+ count[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0)
        res[i] = 0;
      else
        res[i] = count[nums[i] - 1];
    }

    return res;
  }
}
