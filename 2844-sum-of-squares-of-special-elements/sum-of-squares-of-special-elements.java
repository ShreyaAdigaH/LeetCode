class Solution {
    public int sumOfSquares(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for(int index = 1; index <= length; index++) {
            if(length % index == 0) {
                sum += (nums[index - 1] * nums[index - 1]);
            }
        }
        return sum;
    }
}