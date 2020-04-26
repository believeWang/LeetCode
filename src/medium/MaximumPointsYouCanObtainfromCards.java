package medium;

import java.time.Duration;
import java.time.Instant;

/**
 * 5393. Maximum Points You Can Obtain from Cards
 There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.

 In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

 Your score is the sum of the points of the cards you have taken.

 Given the integer array cardPoints and the integer k, return the maximum score you can obtain.



 Example 1:

 Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 Output: 12
 Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 Example 2:

 Input: cardPoints = [2,2,2], k = 2
 Output: 4
 Explanation: Regardless of which two cards you take, your score will always be 4.
 Example 3:

 Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 Output: 55
 Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 Example 4:

 Input: cardPoints = [1,1000,1], k = 1
 Output: 1
 Explanation: You cannot take the card in the middle. Your best score is 1.
 Example 5:

 Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 Output: 202


 Constraints:

 1 <= cardPoints.length <= 10^5
 1 <= cardPoints[i] <= 10^4
 1 <= k <= cardPoints.length
 }
 */
public class MaximumPointsYouCanObtainfromCards {

  public static void main(String[] args) {
    Instant start = Instant.now();
//    int[] a1 = { 96,90,41,82,39,74,64,50,30};//8 => 536
    int[] a1 = { 100,40,17,9,73,75};//3 => 248
//    int[] a1 = { 11,49,100,20,86,29,72};//4=>232
    System.out.println(maxScoreBetter(a1, 3));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static  int maxScore(int[] cardPoints, int k)  {
    int max = 0,  sum = 0;
    for (int i =0; i <= k; i++) {
      sum = 0;
      for (int j =0; j < i; j++) {
        sum += cardPoints[j];
      }
      for (int j =cardPoints.length -1; j > cardPoints.length -1 +i -k; j--) {
        sum += cardPoints[j];
      }
      if (sum > max) max = sum;
    }

    return  max;
  }
  public static  int maxScoreBetter(int[] cardPoints, int k)  {
    int max = 0,  sum = 0;
    int [][] recordLeft = new int[k+1][1];
    int [][] recordRight = new int[k +1][1];
    for (int i =0; i <= k; i++) {

      if (i == 0) {
        recordLeft[i][0] = 0;
        for (int j =cardPoints.length -1; j > cardPoints.length -1 +i -k; j--) {
          sum += cardPoints[j];
        }
        recordRight[i][0]  =sum;
      } else {
        recordLeft[i][0] = recordLeft[i -1][0] + cardPoints[i -1];
        recordRight[i][0] = recordRight[i -1][0] - cardPoints[cardPoints.length -1 +i -k];

      }
      sum = recordLeft[i][0] + recordRight[i][0];


      if (sum > max) max = sum;
    }

    return  max;
  }

}
