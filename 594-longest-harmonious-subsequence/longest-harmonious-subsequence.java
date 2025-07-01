class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            if(countMap.containsKey(num)) {
                countMap.replace(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        int max = 0;
        for(int i : countMap.keySet()) {
            if(countMap.containsKey(i - 1)) {
                int len = countMap.get(i) + countMap.get(i - 1);
                max = Math.max(len, max);
            }
        }
        return max;
    }
}