class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int firstElement = 0;
        int lastElement = size-1;
        while(firstElement<lastElement){
            if(numbers[firstElement] + numbers[lastElement]>target){
                lastElement -= 1;
            }
            if(numbers[firstElement] + numbers[lastElement]<target){
                firstElement += 1;
            }
            if(numbers[firstElement] + numbers[lastElement]==target){
                return new int[]{firstElement +1, lastElement+1};
            }
        }
        return new int[]{-1,-1};
    }
}