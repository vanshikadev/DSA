class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count =0;
        for(int i = nums.length-1; i>1; i--){
            int first = 0;
            int mid = i-1;
            while(first<mid){
                if(nums[first]+nums[mid] > nums[i]){
                    count += mid-first;
                    mid -= 1;
                }
                else{
                    first += 1;
                }
            }
        }
        return count;
    }
}