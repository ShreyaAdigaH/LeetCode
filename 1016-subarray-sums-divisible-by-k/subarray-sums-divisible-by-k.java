class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int numsLength = nums.length;
        int prefixSum = 0;
        int count = 0;
        int[] remainders = new int[k];
        remainders[0] = 1;

        for (int index = 0; index < numsLength; index++) {

            prefixSum += nums[index];
            int remainder = prefixSum % k;

            if (remainder < 0)
                remainder += k;

            if (remainders[remainder] > 0) { // this means that you have added a number along the way that gets divided
                                             // by k. Hence you got the same remainder as before
                count += remainders[remainder];
            }
            remainders[remainder]++;
        }

        return count;
    }
}