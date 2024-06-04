class Solution {
    public int splitArray(int[] nums, int k) {
                int max = 0;
        int sum = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        int minSum = max;
        int maxSum = sum;

        while(minSum <= maxSum) { 
            int middle = (minSum + maxSum) / 2;
            if(isSplitPossible(nums, middle, k)) {
                maxSum = middle - 1; //if split is possible with a weight, try giving lesser weight
            } else {
                minSum = middle + 1;
            }
        }
        return minSum;
    }

    private static boolean isSplitPossible(int[] nums, int trialMax, int k) {
        int kUsed = 0;
        for(int num = 0; num < nums.length; num++) {
            int currentTotal = 0;
            while(num < nums.length && currentTotal + nums[num] <= trialMax) {
                currentTotal += nums[num];
                num++;

            }
            kUsed++;
            num--;
        }
        if(kUsed <= k)
            return true;
        return false;
    }
}