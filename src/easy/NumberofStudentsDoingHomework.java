package easy;

import java.time.Duration;
import java.time.Instant;

/**
 * 5412. Number of Students Doing Homework at a Given Time
 * Given two integer arrays startTime and endTime and given an integer queryTime.
 *
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
 *
 * Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * Output: 1
 * Explanation: We have 3 students where:
 * The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
 * The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
 * The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
 * Example 2:
 *
 * Input: startTime = [4], endTime = [4], queryTime = 4
 * Output: 1
 * Explanation: The only student was doing their homework at the queryTime.
 * Example 3:
 *
 * Input: startTime = [4], endTime = [4], queryTime = 5
 * Output: 0
 * Example 4:
 *
 * Input: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
 * Output: 0
 * Example 5:
 *
 * Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
 * Output: 5
 */
public class NumberofStudentsDoingHomework {

  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] a1 = { 1,2,3};
    int[] a2 = { 3,2,7};
    System.out.println(busyStudent(a1,a2,4));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");
    System.out.println(Duration.between(start, end).toMillis());

  }

  public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int cnt = 0 ;
    for (int i = 0; i < startTime.length; i++) {

      if (startTime[i] <= queryTime && endTime[i] >= queryTime) cnt ++;
    }
    return cnt;

  }
}
