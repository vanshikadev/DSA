class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        if(n<=1){
            return 0;
        }
        int [][] dp = new int[n+1][n+1];
        dp[0][0] = 0;
        for(int i = 1; i<=n; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i =1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == s.charAt(n-j)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[n][n];
    }
}