class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            // compute ans[i]
            int[] freq = new int[51];
            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }

            List<int[]> freqKeyVal = new ArrayList<>();

            for (int j = 1; j < 51; j++) {
                if (freq[j] > 0) {
                    freqKeyVal.add(new int[] {freq[j], j});
                }
            }
            freqKeyVal.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);

            int sum = 0;

            for (int j = 0; j < x && j < freqKeyVal.size(); j++) {
                sum += freqKeyVal.get(j)[0] * freqKeyVal.get(j)[1];

            }

            ans[i] = sum;
        }
        return ans;
    }
}