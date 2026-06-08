class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                high = mid;
            }
            if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low; 
    }
}