class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

       int count = 0;
        for(int i = 0; i < nums.length; ) {
            int curr = nums[i];
            while(i < nums.length && nums[i] - curr <= k) {
                i++;
            }
            count++;
        }
        return count;
    }
}