package Array;

import java.util.Arrays;

public class Ques25_BestTimeToBuyAndSellStock3 {
    public static int f(int day, int isBought, int chance, int[] prices, int[][][] dp) {
        if(chance == 0 || day >= prices.length)return 0;

        if(dp[day][isBought][chance] != -1)return dp[day][isBought][chance];

        int x; int y;
        if(isBought == 0) {
            x = -prices[day] + f(day+1, 1, chance, prices, dp); // buy
            y = f(day+1, 0, chance, prices, dp); // don't buy
        } else {
            x = prices[day] + f(day+1, 0, chance-1, prices, dp); // sell
            y = f(day+1, 1, chance, prices, dp); // don't sell
        }

        int maxi = Math.max(x, y);

        return dp[day][isBought][chance] = maxi;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][3];

        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return f(0, 0, 2, prices, dp);
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = maxProfit(prices);

        System.out.println(res);
    }
}
