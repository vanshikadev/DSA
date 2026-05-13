class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i : nums){
            if(map.containsKey(target - i)){
                return new int[]{map.get(target - i), index};
            }
            else{
                map.put(i , index );
                index ++ ;
            }
        }  
        return new int[]{-1,-1};
    }
}