class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0; 
        int high = nums.length;
        int first = findFirstElement(nums,target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int second = findSecondElement(nums,target);
        return new int[]{first,second};
    }
    private int findFirstElement(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        if(nums.length == low || nums[low] != target ){
            return -1;
        }
        return low;
    }
     private int findSecondElement(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                low = mid +1;
            }
            if(nums[mid] < target){
                low = mid + 1;
            }
            if(nums[mid] > target){
                high = mid;
            }
        }
        int idx = low - 1;
        if(idx < 0 || nums[idx] != target ){
            return -1;
        }
        return idx;
    }
}