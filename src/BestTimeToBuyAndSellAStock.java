public class BestTimeToBuyAndSellAStock {

    public static int maxProfit(int[] prices) {

        int min_value = Integer.MAX_VALUE;
        int total_profit = 0;
        int profit_sold_today = 0;

        for (int price : prices) {
            if (price < min_value) {
                min_value = price;
            }
            profit_sold_today = price - min_value;
            if (profit_sold_today > total_profit) {
                total_profit = profit_sold_today;
            }
        }

        return total_profit;
    }

}
