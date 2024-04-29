class Solution {
    public int minOperations(int[] nums, int k) {
              int bitwiseXOR = k;
        int count = 0;
        for(int num : nums)
            bitwiseXOR = bitwiseXOR ^ num;

        while(bitwiseXOR != 0) {
            if(bitwiseXOR % 2 == 1)
                count++;
            bitwiseXOR = bitwiseXOR >> 1;
        }
        return count;
    }
}