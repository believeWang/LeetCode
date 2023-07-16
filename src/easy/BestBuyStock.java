package easy;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class BestBuyStock {

  public static void main(String[] args) {

  }

  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
      if (min > price) min = price;
      int profit = price - min;
      if (maxProfit < profit) maxProfit = profit;


    }

    return maxProfit;

  }
}
