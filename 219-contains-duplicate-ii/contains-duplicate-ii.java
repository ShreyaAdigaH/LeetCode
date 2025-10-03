class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1) 
          return false;
        HashSet<Integer> freq = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(freq.contains(nums[i])) {
                return true;
            }

            freq.add(nums[i]);

            if(freq.size() > k) {
                freq.remove(nums[i - k]);
            }
        }

        return false;
      
    }
}