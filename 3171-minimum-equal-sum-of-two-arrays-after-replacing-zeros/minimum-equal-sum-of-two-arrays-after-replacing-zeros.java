class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        //count largest sum and number of zeros in it
        // smallest sum array must have atleast 1 zero

        long sum1 = 0;
        int count1 = 0;
        long sum2 = 0;
        int count2 = 0;

        for (int num : nums1) {
            sum1 += num;

            if (num == 0) {
                count1++;
                sum1++;
            }
        }

        for (int num : nums2) {
            sum2 += num;

            if (num == 0) {
                count2++;
                sum2++;
            }
        }

        if ((count1 == 0 && sum2 > sum1) || (count2 == 0 && sum1 > sum2)) {
            return -1;
        }

        return Math.max(sum1, sum2);

    }
}