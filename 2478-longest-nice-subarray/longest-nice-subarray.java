class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int res = 0;
        int curr = 0;

        for(int r = 0; r < nums.length; r++) {
            while((curr & nums[r]) != 0) { 
                curr = curr ^ nums[l];
                l = l + 1;
            } 
            res = Math.max(res, r - l + 1);
            curr = curr | nums[r];
        }
        return res;
    }
}