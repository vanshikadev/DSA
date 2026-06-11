class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bisect_left(nums, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int second = bisect_right(nums,target);
        return new int[]{first,second};
    }

    private int bisect_left(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low == nums.length || nums[low] != target) {
            return -1;
        }
        return low;
    }

    private int bisect_right(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        int idx = low - 1;
        if(idx < 0 || nums[idx] != target){
            return -1;
        }
        return idx;

    }
}