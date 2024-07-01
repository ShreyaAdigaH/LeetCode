class Solution {
    public int duplicateNumbersXOR(int[] nums) {
                int[] freq = new int[51];
        int result = 0;
        
        for(int num : nums) {
            freq[num]++;

            if(freq[num] % 2 == 0) {
                result = result ^ num;
            }
        }
        return result;
    }
}