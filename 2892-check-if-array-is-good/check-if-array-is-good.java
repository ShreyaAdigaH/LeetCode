class Solution {
    public boolean isGood(int[] nums) {
        int freq[] = new int[nums.length + 1];
        int max = nums.length;

        if(nums.length == 1) {
           return false;
        }
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] > nums.length) {
                return false;
            } 
            freq[nums[index]]++;
        }
        System.out.println(Arrays.toString(freq));
        for(int index = 1; index <= nums.length - 1; index++) {
            if(index == nums.length - 1) {
                 if(freq[index] != 2) {
                    return false;
                 }
            } else {
                 if(freq[index] != 1) {
                    return false;
                 }
            }
        }
        return true;
    }
}