package easy;

/**
 * You are given a 0-indexed integer array nums. A pair of indices i, j where 0 <= i < j < nums.length is called beautiful if the first digit of nums[i] and the last digit of nums[j] are coprime.
 * <p>
 * Return the total number of beautiful pairs in nums.
 * <p>
 * Two integers x and y are coprime if there is no integer greater than 1 that divides both of them. In other words, x and y are coprime if gcd(x, y) == 1, where gcd(x, y) is the greatest common divisor of x and y.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,1,4]
 * Output: 5
 * Explanation: There are 5 beautiful pairs in nums:
 * When i = 0 and j = 1: the first digit of nums[0] is 2, and the last digit of nums[1] is 5. We can confirm that 2 and 5 are coprime, since gcd(2,5) == 1.
 * When i = 0 and j = 2: the first digit of nums[0] is 2, and the last digit of nums[2] is 1. Indeed, gcd(2,1) == 1.
 * When i = 1 and j = 2: the first digit of nums[1] is 5, and the last digit of nums[2] is 1. Indeed, gcd(5,1) == 1.
 * When i = 1 and j = 3: the first digit of nums[1] is 5, and the last digit of nums[3] is 4. Indeed, gcd(5,4) == 1.
 * When i = 2 and j = 3: the first digit of nums[2] is 1, and the last digit of nums[3] is 4. Indeed, gcd(1,4) == 1.
 * Thus, we return 5.
 * Example 2:
 * <p>
 * Input: nums = [11,21,12]
 * Output: 2
 * Explanation: There are 2 beautiful pairs:
 * When i = 0 and j = 1: the first digit of nums[0] is 1, and the last digit of nums[1] is 1. Indeed, gcd(1,1) == 1.
 * When i = 0 and j = 2: the first digit of nums[0] is 1, and the last digit of nums[2] is 2. Indeed, gcd(1,2) == 1.
 * Thus, we return 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 9999
 * nums[i] % 10 != 0
 */
public class BeautifulPairs {

  public static void main(String[] args) {
    int[] i1 = new int[]{2, 5, 1, 4};
    int[] i2 = new int[]{11, 21, 12};
    int[] i3 = new int[]{84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
//    System.out.println(countBeautifulPairs(i1));
//    System.out.println(countBeautifulPairs(i2));
    System.out.println(countBeautifulPairs(i3));
  }

  public static int countBeautifulPairs(int[] nums) {
    int cnt = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {

        int num = nums[i];
        int num1 = nums[j];
        int firstDigit = getFirstDigit(num);
        int lastDigit = getLastDigit(num1);
        if (gcd(firstDigit, lastDigit) == 1) cnt++;
      }
    }
    return cnt;
  }

  public static int gcd(int n, int m) {
    if (n % m == 0)
      return m;
    else
      return gcd(m, n % m);
  }
  public static int getFirstDigit(int n) {
    int digitsNumber = getDigitsNumber(n);
    return digitsNumber ==1 ? n :n/ (int) (Math.pow(10, digitsNumber-1));
  }
  public static int getLastDigit(int n) {
    int digitsNumber = getDigitsNumber(n);
    return digitsNumber ==1 ? n : n % (int) Math.pow(10, 1) ;
  }

  public static int getDigitsNumber(final double d) {
    return (int) Math.log10(d) + 1;
  }


}
