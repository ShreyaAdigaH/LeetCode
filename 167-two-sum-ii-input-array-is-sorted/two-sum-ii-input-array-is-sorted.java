class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int rp = numbers.length - 1;
        int lp = 0;
 
        while(lp < rp) {
            int currSum = numbers[lp] + numbers[rp];

            if(currSum < target) {
                lp++;
            } else if(currSum > target) {
                rp--;
            } else {
                return new int[] {lp + 1, rp + 1};
            }
        }
        return new int[] {0};
    }
}