package easy;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 1、冒泡排序（Bubble Sort） 冒泡排序是一種簡單的排序算法。它重複地走訪過要排序的數列，一次比較兩個元素，
 如果它們的順序錯誤就把它們交換過來。走訪數列的工作是重複地進行直到沒有再需要交換，也就是說該數列已經排序完成。
 這個算法的名字由來是因為越小的元素會經由交換慢慢“浮”到數列的頂端。
 */
public class NumberSort {
  public static void main(String[] args) {
    Instant start = Instant.now();
    int[] a1 = { 6,36,5,19,50,4,15,3,49,8};
    printArray(a1);
    printArray(quickSort(a1, 0, a1.length -1));
    Instant end = Instant.now();
    System.out.println();
    System.out.println(Duration.between(start, end).toMillis() + "ms");

  }
  private static void printArray(int [] array) {
    Arrays.stream(array).mapToObj(num -> num + " ").forEach(System.out::print);
    System.out.println();
  }

  /**
   * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
   * @param array
   * @param start
   * @param end
   * @return
   */
  public static int[] quickSort(int[] array, int start, int end) {
    if (array == null ||start < 0 || end > array.length - 1 ) {
      return null;
    }
    System.out.println("start-end"+start+"-"+end);
    int partition = partition(array, start, end);// 代表 這個index 的位置是正確的 因為比較小的經過partition() 之後都在她左邊 比較大的 都在右邊
    if (start < partition) {
      quickSort(array,start,partition -1); // partition 之前的繼續進行排列  因為partition 已經是對的 所以-1
    }
    if (end > partition){
      quickSort(array,partition + 1,end); // partition 之後的繼續進行排列  因為partition 已經是對的 所以+1
    }
    return array;
  }

  /**
   * 隨機挑選一個index 比她小的放左邊，比他大的放右邊
   * @param array
   * @param start
   * @param end
   * @return
   */
  public static int partition(int[] array, int start, int end) {
    int mid = (int) (start + Math.random() * (end - start + 1));
    int smallIndex = start -1; //先歸0 (放到最左邊)  smallIndex 代表目前比隨機數小的已經放了幾個
    swap(array, mid, end); //把隨機選出來的中間數放到最後一個
    for(int i = start; i<= end;i++) {
      if(array[i] <= array[end]) { // 比她中間數(array[end]小的才處理  如果相等 代表將 array[end] 換到他正確的位置 也就是  array[smallIndex]
        smallIndex++; //如果比較小就往右邊左
        if (i > smallIndex) {  // 如果現在的位置 比 最小的 還大 才需要交換位置，因為如果i = small 代表目前所有的都比隨機數小 不需要移動
          swap(array, i, smallIndex); // 現在比較到最小的  放到左邊去
        }
      }
    }
    System.out.println("smallIndex: "+ smallIndex);
    return smallIndex; //回傳最小的
  }
  private static int[] bubbleSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length -1 - i; j++) {
        if (array[j + 1] < array[j]) {
          swap(array,j,j+1);
        }
      }

    }
    return  array;
  }

  public static void swap(int[] array, int i, int j) {
    printArray(array);
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    printArray(array);
  }
}
