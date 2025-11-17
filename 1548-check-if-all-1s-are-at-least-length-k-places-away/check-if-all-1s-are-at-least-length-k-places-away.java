class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int space = k;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(space < k) {
                    return false;
                }
                space = 0;
            } else {
                space += 1;
            }
        }
        return true;
    }
}