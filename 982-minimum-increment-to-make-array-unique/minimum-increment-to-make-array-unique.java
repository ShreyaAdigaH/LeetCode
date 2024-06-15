class Solution {
    public int minIncrementForUnique(int[] nums) {
               // Basically after sorting each number should be different as the previous one
        // next available number should take the value which is either +1 of the previous number or the current number, whichever is maximum
        // if number is not greater than the previous number then the number would be equal to current number
        // In that case we have to increment it to next greatest number available
        // For that just increment the current number which is same as the previous one, by 1 unit
        // After incrementing the current duplicate number by 1 check the next number
        // If the next number is lesser than the previous number in that case increase the next number as well
        // Repeat the same until you no longer find a duplicate number or number that is lesser than current number
        //
        Arrays.sort(nums);
        int nextAvailNum = 0; 
        int increment = 0; 

        for (int num : nums) {
            nextAvailNum = Math.max(nextAvailNum, num);
            increment += nextAvailNum - num;
            nextAvailNum += 1; 
        }

        return increment;
    }
}