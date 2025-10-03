class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // int sum = 0;
        // int count = 0;
        // double avg = 0;
        // double res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     count++;
        //     sum += nums[i];
        //     if (count == k) {
        //         avg = (double) sum / k;

        //         sum -= nums[i - (k - 1)];
        //         count -= 1;
        //         res = Math.max(avg, res);
        //         avg = 0;
        //     }
        // }
        // return res;

        int sum = 0;
        for(int i = 0; i < k; i++) { 
            sum += nums[i];
        }

        int maxSum = sum;

        for(int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i - k]);
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum / k;
    }
}