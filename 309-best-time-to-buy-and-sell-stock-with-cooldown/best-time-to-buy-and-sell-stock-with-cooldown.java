class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
        int[][] dp = new int[n][2];
        if (n <= 1) {
            return 0;
        }
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0] , -prices[1]);
        for (int i = 2; i < n; i++) {
           // Not holding: do nothing or sell
            dp[i][0] = Math.max(
                dp[i-1][0],
                dp[i-1][1] + prices[i]
            );

            // Holding: keep holding or buy today
            dp[i][1] = Math.max(
                dp[i-1][1],
                dp[i-2][0]-prices[i]
            );
    }
    return Math.max(dp[n-1][0], dp[n-1][0]);
    }
}