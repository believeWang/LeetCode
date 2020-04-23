package medium;

import java.time.Duration;
import java.time.Instant;

/**
 *11. Container With Most Water
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.





 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



 Example:

 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49
 */
public class ContainerWithMostWater {

  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] a1 = { 1,8,6,2,5,4,8,3,7};
    for (int i=0; i<1000;i++)
    System.out.println(maxArea(a1));
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }

  public static  int maxArea(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length -1; i++) {
      if (i > 0 && height[i] < height[i -1]) continue;
      for (int j = i +1; j < height.length; j++) {
        int areaHeight = Math.min(height[i], height[j]);
        int areaLong = j - i;
        int area = areaHeight * areaLong;
        if (max < area) max = area;
      }
    }
    return max;

  }

  public static  int maxAreaBetter(int[] height) {
    int max = 0, left = 0 , right = height.length - 1;
    while(left < right) {
      int areaHeight = Math.min(height[left], height[right]);
      int areaLong = right -left;
      int area = areaHeight * areaLong;
      if (max < area) max = area;
      if (height[left] < height[right]) {
        left ++;
      } else {
        right --;
      }

    }
    return max;

  }
}
