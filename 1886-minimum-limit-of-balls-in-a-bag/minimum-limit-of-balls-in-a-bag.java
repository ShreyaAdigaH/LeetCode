class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);

        int max = nums[nums.length - 1];

        int leastP = 1;
        int highestP = max;

        int result = 0;

        while (leastP <= highestP) {
            int midP = leastP + (highestP - leastP) / 2;

            int noOfSplits = 0;
            boolean canSplit = true;

            for (int balls : nums) {
                noOfSplits += (balls - 1) / midP;
                if (noOfSplits > maxOperations) {
                    canSplit = false;
                    break;
                }
            }

            if (canSplit) {
                result = midP;
                highestP = midP - 1;
            } else {
                leastP = midP + 1;
            }

        }

        return result;
    }
}