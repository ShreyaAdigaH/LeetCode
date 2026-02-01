class Solution {
    public int minimumCost(int[] nums) {
         int firstMin = nums[1];
        int secondMin = nums[2];

        for (int index = 2; index < nums.length; index++) {
            if (nums[index] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[index];
            } else if (nums[index] < secondMin) {
                secondMin = nums[index];
            }
        }

        return nums[0] + firstMin + secondMin; 
    }
}