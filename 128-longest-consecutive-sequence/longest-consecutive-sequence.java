class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<Integer>();

        for(int num : nums) {
            numsSet.add(num);
        }

        int max = 0;
        for(int num : numsSet) {
            if(!numsSet.contains(num - 1)) {
                int curCount = 1;
                while(numsSet.contains(num + curCount)) {
                    curCount++;
                }
                max = Math.max(curCount, max);
            }
        }
        return max;
    }
}