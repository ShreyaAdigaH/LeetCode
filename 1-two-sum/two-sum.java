class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numIndex = new HashMap<>();

        for(int idx = 0; idx < nums.length; idx++) {
            numIndex.put(nums[idx], idx);
        }

        for(int idx = 0; idx < nums.length; idx++)  {
            if(numIndex.containsKey(target - nums[idx])) {
                if(numIndex.get(target - nums[idx]) != idx) {
                    return new int[]{idx, numIndex.get(target - nums[idx])};
                }
            }
        }

        return new int[]{0};
    }
}