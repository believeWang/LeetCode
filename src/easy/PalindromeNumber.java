package easy;

/**
 * 9. Palindrome Number
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class PalindromeNumber {

  public static boolean isPalindrome(int x) {
    if (x < 0) return false;
    int digitsNumber = getDigitsNumber(x);
    for (int i = 1; i <= digitsNumber / 2; i++) {
      int i1 = x / (int) (Math.pow(10, digitsNumber - i)) % (int) (Math.pow(10, 1));

      int i2 = x % (int) Math.pow(10, i) / (int) Math.pow(10, i - 1);
      if (i1 != i2) return false;
    }

    return true;
  }

  public static int getDigitsNumber(final double d) {
    return (int) Math.log10(d) + 1;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(1234321));
  }
}
