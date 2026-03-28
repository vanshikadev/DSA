class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0]=1;
        for(int i =1;i<n;i++){
            result[i]= nums[i-1]*result[i-1];
        }
        int mul = 1;
        for(int k = result.length-1; k>=0; k--){
            result[k] = result[k]*mul;
            mul *= nums[k];
        }
        return result;

    }
}