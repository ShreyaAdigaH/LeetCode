class Solution {
    public int countValidSelections(int[] nums) {
    
        int nonZeros = 0;
        int count = 0;

        for(int num : nums) {
            if(num > 0)
                nonZeros++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(isValid(nums, i, 1, nonZeros))
                    count++;
                if(isValid(nums, i, -1, nonZeros))
                    count++;
            }
        }
        return count;
    }

    public boolean isValid(int[] nums, int start, int dir, int nonZeros) {
        int[] temp = nums.clone();
        int curr = start;
        int n = nums.length;

        while(nonZeros > 0 && curr < n && curr >= 0) {
            if(temp[curr] > 0) {
                temp[curr]--;
                dir = dir * -1;
                if(temp[curr] == 0)
                    nonZeros--;
            }
                curr += dir;
        }
        return nonZeros == 0;
    }
}