class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int maxConsecutiveOnes = 0;
        int currentMaxCount = 0;
        int temp = 0;
        for(int number : nums){
            if(number == 1) {
                currentMaxCount++;
            } else {
                temp = temp > currentMaxCount ? temp : currentMaxCount ;
                currentMaxCount = 0;
            }

        }
        maxConsecutiveOnes = currentMaxCount > temp ? currentMaxCount : temp;
        return maxConsecutiveOnes;
    }
}