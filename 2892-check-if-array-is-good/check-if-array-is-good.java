class Solution {
    public boolean isGood(int[] nums) {
        int freq[] = new int[nums.length + 1];
        int max = nums.length;

        if (nums.length == 1) {
            return false;
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > nums.length) {
                return false;
            }
            freq[nums[index]]++;
        }

        if (freq[nums.length - 1] != 2) {
            return false;
        }
        for (int index = 1; index <= nums.length - 2; index++) {
            if (freq[index] != 1) {
                return false;
            }
        }
        return true;
    }
}