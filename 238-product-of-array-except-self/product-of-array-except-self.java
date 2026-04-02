class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[]arr = new int[size];
        int mult = 1;
        arr[0] = mult;
        for(int i =1; i< size;i++){
            mult = mult*nums[i-1];
            arr[i]= mult;
        }
        int mult2 = 1;
        for(int j = nums.length-1; j>=0 ;j--){
            arr[j]= arr[j]*mult2;
            mult2 = nums[j]*mult2;
        }
        return arr;


    }
}