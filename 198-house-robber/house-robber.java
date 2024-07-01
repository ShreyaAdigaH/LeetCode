class Solution {
    public int rob(int[] nums) {
          if(nums.length == 1) {
            return nums[0];
        } 
        
        int[] cumulativeLoot = new int[nums.length + 1];
        cumulativeLoot[0] = 0;
        cumulativeLoot[1] = nums[0];

 

        for(int idx = 1; idx  < nums.length; idx++) {
            cumulativeLoot[idx + 1] = Math.max(nums[idx] + cumulativeLoot[idx - 1],  cumulativeLoot[idx]);
        }
        
        return cumulativeLoot[nums.length];
    }
}