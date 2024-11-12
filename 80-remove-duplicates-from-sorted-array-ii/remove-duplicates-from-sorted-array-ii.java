class Solution {
    public int removeDuplicates(int[] nums) {
        int fp = 0;
        int cp = 0;
        int count = 0;
        while(cp < nums.length) {
            int freq = 0;
            int curr = nums[cp];
            while(cp < nums.length && nums[cp] == curr) {
                freq ++;
                if(freq > 2) {
                    cp++;
                } else {
                    nums[fp++] = nums[cp++];
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}