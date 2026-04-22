package Array;

public class Ques17_BestTimtToBuyAndSellStock1 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int mini = Integer.MAX_VALUE;
        int ans = 0;

        for (int price : prices) {
            mini = Math.min(mini, price); // keep a tab of minimum till now

            ans = Math.max(ans, price - mini); // and then update the ans according to max(ans, curr - minimum till now)
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        int ans = maxProfit(prices);

        System.out.println(ans);
    }
}
