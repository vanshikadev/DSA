class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = low + (high - low)/2;
            // nums[mid] == target
            if(nums[mid] == target) high = mid;

            // nums[mid] < target
            else if(nums[mid] < target) low = mid + 1;

            // nums[mid] > target
            else high = mid - 1;
        }

        return nums[low] == target ? low : -1;
    }
}