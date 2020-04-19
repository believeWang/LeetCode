package medium;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 Have the function SeatingStudents(arr) read the array of integers stored in arr which will be in the following format: [K, r1, r2, r3, ...] where K represents the number of desks in a classroom, and the rest of the integers in the array will be in sorted order and will represent the desks that are already occupied. All of the desks will be arranged in 2 columns, where desk #1 is at the top left, desk #2 is at the top right, desk #3 is below #1, desk #4 is below #2, etc. Your program should return the number of ways 2 students can be seated next to each other. This means 1 student is on the left and 1 student on the right, or 1 student is directly above or below the other student.

 For example: if arr is [12, 2, 6, 7, 11] then this classrooms looks like the following picture:



 Based on above arrangement of occupied desks, there are a total of 6 ways to seat 2 new students next to each other. The combinations are: [1, 3], [3, 4], [3, 5], [8, 10], [9, 10], [10, 12]. So for this input your program should return 6. K will range from 2 to 24 and will always be an even number. After K, the number of occupied desks in the array can range from 0 to K.
 Examples
 Input: new int[] {6, 4}
 Output: 4
 Input: new int[] {8, 1, 8}
 Output: 6
 */
public class SeatingStudents {

  public static int SeatingStudents(int[] arr) {
    int size = arr[0];
    LinkedList<Integer> occupied = new LinkedList<>();
    for (int i = 1; i < arr.length; i++) {

      occupied.add(arr[i]);
    }
    int result = 0;
    for (int i = 1 ; i <= size ; i++) {
      if (occupied.contains(i)) {
        occupied.remove(new Integer(i));
        continue;
      }
      //even
      if (i % 2 == 0) {
        if (!occupied.contains(i + 2) && i != size ) {
          result ++ ;
        }

      } else {
        //odd
        if (!occupied.contains(i + 1)) {
          result ++ ;
        }
        if (!occupied.contains(i + 2) && i != size -1) {
          result ++ ;
        }
      }
    }
    // code goes here
    return result;
  }
  public static void isOccupied(int index, LinkedList<Integer> occupied) {


  }
  public static void main (String[] args) {
//    int[] a1 = {12,2,6,7,11};  => 6
    int[] a1 = {6,4};
    System.out.print(SeatingStudents(a1));
  }

}
