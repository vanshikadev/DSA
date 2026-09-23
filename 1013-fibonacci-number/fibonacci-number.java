class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int prev_2 = 0;
        int prev_1 = 1;
        int curr = prev_1 + prev_2;
        for(int i =2;i<n+1;i++){
            curr = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = curr;
        }
        return curr;
    }
}