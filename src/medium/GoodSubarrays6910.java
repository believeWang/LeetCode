package medium;

/**
 * You are given a binary array nums.
 *
 * A subarray of an array is good if it contains exactly one element with the value 1.
 *
 * Return an integer denoting the number of ways to split the array nums into good subarrays. As the number may be too large, return it modulo 109 + 7.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 */
public class GoodSubarrays6910 {
  public static void main(String[] args) {
//    int[] i1 = new int[]{0,1,0,0,1};
//    int[] i2 = new int[]{0,1,0};
    int[] i3 = new int[]{0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,0,1,0,1,0,1,1,0,0,0,0,0,1,0,0,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1,1,1,0,1,1,0,0,1,1,1,0,0,1,0,0,1,1,0,1,0,1,1,1,0,0,1,0,0,0,1,0,0,1,0,0,1,1,1,1,0,0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,1,0,1,1,1,1,1,0,1,0,1,0,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,0,1,0,0,1,0,1,0,1,1,1,0,1,0,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,1,1,0,0,1,0,1,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,1,0,0,0,0,1,0,0,0,1,0,1,0,1,1,1,1,0,0,0,1,0,0,1,0,0,0,1,0,1,1,1,0,1,1,0};
    //01 01 01
    //010 1 01
    //010 10 1
    //01 010 1

    System.out.println(numberOfGoodSubarraySplits2(i3));
    System.out.println(numberOfGoodSubarraySplits(i3));
  }
  public static int numberOfGoodSubarraySplits(int[] nums) {
    int countOne = countOne(nums);
    if (countOne ==0 ) return 0;
    if (countOne ==1 ) return 1;
    int []oneIndex = new int[countOne];
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        oneIndex[j] =i;
        j++;
      }

    }
    long result =1;
    int max = (int)1e9 + 7;
    for (int i = 1; i < oneIndex.length; i++) {
      int i1 = oneIndex[i] - oneIndex[i - 1];
      if (i1 > 1) {
        result = (result * i1) % max;
      }

    }
    return  (int)result;
  }
  public static int countOne(int[] nums) {
    int cnt =0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i]==1)cnt++;
    }
    return cnt;


  }

  public static int numberOfGoodSubarraySplits2(int[] nums) {
    final int n = nums.length;
    long count = 0;

    // find the first one
    int i = 0;
    while (i < n && nums[i] != 1) {
      i++;
    }

    if (i < n) {
      count++;
    }

    for (int j = i + 1; j < n; j++) {
      while (j < n && nums[j] == 0) {
        j++;
      }

      if (j < n && nums[j] == 1) {
        // we have j - i cuts with zero between two one(i, j)
        // 10...01
        // i ... j
        count = count * (j - i) % (int) (1e9 + 7) ;
        System.out.println(count);
        i = j;
      }
    }

    return (int) count;
  }
}
