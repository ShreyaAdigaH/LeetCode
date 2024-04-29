class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = k;
        int count = 0;
        for(int num : nums)
            xor = xor ^ num;

        while(xor != 0) {
            if(xor % 2 == 1)
                count++;
            xor = xor >> 1;
        }
        return count;
    }
}