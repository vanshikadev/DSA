class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lastElement = numbers.length - 1;
        int firstElement = 0;

        while(firstElement < lastElement){
            if(numbers[firstElement] + numbers[lastElement] > target){
                lastElement --;
            }
            if(numbers[firstElement] + numbers[lastElement] < target){
                firstElement++;
            }
            if(numbers[firstElement] + numbers[lastElement] == target){
                return new int[]{firstElement+1 , lastElement +1};
            }
        }
        return new int []{-1,-1};
    }
}