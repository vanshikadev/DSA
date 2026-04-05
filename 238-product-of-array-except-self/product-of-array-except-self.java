class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mult1 = 1;
        int size = nums.length;
        int mult2=1;
        int[] arr = new int[size];
        for(int i = 0; i< size;i++){
            arr[i]= mult1;
            mult1 *= nums[i];
        }
        for(int i = size-1; i>=0; i--){
            arr[i] = arr[i]*mult2;
            mult2 *= nums[i];
        }
        return arr;
    }
}