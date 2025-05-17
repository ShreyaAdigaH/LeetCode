class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int num : nums) {
            freq[num]++;
        }

        int tracIn = 0;
        for(int i = 0; i < 3; i++) {
            int count = freq[i];

            for(int j = 0; j < count; j++) {
                nums[tracIn++] = i;
            }
        }

    }
}