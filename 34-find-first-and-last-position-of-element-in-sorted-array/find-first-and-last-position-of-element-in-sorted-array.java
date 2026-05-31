class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = bisect_left(nums,target);
        if(left == nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }
        int right = bisect_right(nums,target);
        result[0] = left;
        result[1] = right-1;
        return result;
    }
    private int bisect_right(int[] nums, int target){
        int low = 0;
        int high = nums.length;

        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                low = mid+1;
            }
            else if (nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    private int bisect_left(int[] nums , int target){
        int low = 0;
        int high = nums.length;

        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                high = mid;
            }
            else if (nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}