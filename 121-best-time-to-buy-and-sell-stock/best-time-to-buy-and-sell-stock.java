class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n][2];
        if(n<= 1){
            return 0;
        }
        int previous_notholding = 0;
        int previous_holding = -prices[0];
        int current_notholding =0;
        int current_holding;
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];
        for(int i = 1; i<n;i++){
            current_notholding = Math.max(previous_notholding, previous_holding + prices[i]);
            current_holding = Math.max(previous_holding, -prices[i]);
            previous_holding = current_holding;
            previous_notholding = current_notholding;
        }
        return current_notholding;
    }
}