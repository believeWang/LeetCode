package medium;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

/**
 * Given a number s in their binary representation. Return the number of steps to reduce it to 1 under the following rules:
 *
 * If the current number is even, you have to divide it by 2.
 *
 * If the current number is odd, you have to add 1 to it.
 *
 * It's guaranteed that you can always reach to one for all testcases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1101"
 * Output: 6
 * Explanation: "1101" corressponds to number 13 in their decimal representation.
 * Step 1) 13 is odd, add 1 and obtain 14.
 * Step 2) 14 is even, divide by 2 and obtain 7.
 * Step 3) 7 is odd, add 1 and obtain 8.
 * Step 4) 8 is even, divide by 2 and obtain 4.
 * Step 5) 4 is even, divide by 2 and obtain 2.
 * Step 6) 2 is even, divide by 2 and obtain 1.
 * Example 2:
 *
 * Input: s = "10"
 * Output: 1
 * Explanation: "10" corressponds to number 2 in their decimal representation.
 * Step 1) 2 is even, divide by 2 and obtain 1.
 * Example 3:
 *
 * Input: s = "1"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of characters '0' or '1'
 * s[0] == '1'
 */
public class ReduceBinaryRepresentationToOne {

  public static void main(String[] args) {
    Instant start = Instant.now();
//    System.out.println(numSteps("1111011110000011100000110001011011110010111001010111110001"));
    System.out.println(numSteps2("1111011110000011100000110001011011110010111001010111110001"));
//    System.out.println(numSteps2("1101"));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static int numSteps(String s) {

    BigDecimal sum = new BigDecimal("0");
    BigDecimal base = new BigDecimal(2);
    BigDecimal temp;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)== '1'){
        int exponent= s.length()-1-i;
        temp=base.pow(exponent);
        sum=sum.add(temp);
      }

    }

    System.out.println("AAA" +sum );

    int cnt = 0;
    while (sum.compareTo(BigDecimal.ONE) > 0) {
      cnt ++;
      if (sum.remainder(new BigDecimal("2")).compareTo(BigDecimal.ZERO) == 0) {
        sum = sum.divide(new BigDecimal("2"), 0 , BigDecimal.ROUND_DOWN);
      } else {
        sum =sum.add(BigDecimal.ONE) ;
      }
    }


    return cnt;
  }
  public static int numSteps2(String s) {
    int cnt = 0;
    while (!s.equals("1")) {
      cnt ++;
      if (s.charAt(s.length()-1) == '0') {
        s = s.substring(0,s.length()-1);
      } else {
        StringBuilder temp = new StringBuilder("0");
        int i =s.length() -2;
        for (; i >= 0 ;i-- ) {
           if (s.charAt(i) == '1') {
             temp.append("0");
           } else {
             temp.insert(0,"1");

             break;
           }

        }
        s = i == -1 ? "1" + temp.toString() :s.substring(0,i) + temp.toString();
      }
    }



    return cnt;
  }
}
