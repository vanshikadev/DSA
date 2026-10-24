class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        if(n == 0){
            return 0;
        }
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1: 0;
        for(int i = 2;i<n+1;i++){
            char c =  s.charAt(i-1);
            if(c != '0'){
                dp[i] = dp[i] + dp[i-1];
            }
                int num = Integer.parseInt(s.substring(i-2,i));
            if(num>=10 && num <= 26){
                    dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[n];
    }
}