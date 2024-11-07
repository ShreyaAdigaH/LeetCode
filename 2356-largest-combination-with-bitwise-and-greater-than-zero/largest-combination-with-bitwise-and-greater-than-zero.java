class Solution {
    public int largestCombination(int[] candidates) {
          int maxLen = 0;
          int count = 0;
          int bit = 0;
            for(int i = 0; i <= 32; i++) {
                count = 0;
                for(int candidate : candidates) {
                    bit = (1 << i) & candidate;
                    if(bit != 0) {
                        count++;
                    }
                }
                maxLen = Math.max(count, maxLen);
            }
            return maxLen;
    }
}