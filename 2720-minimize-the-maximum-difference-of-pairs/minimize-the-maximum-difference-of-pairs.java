class Solution {
    int[] numA;
    int p1;

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        numA = nums;
        p1 = p;
        // bs to check least possible diff, so that i could form enough pairs p with that diff
        int lp = 0;
        int rp = nums[nums.length - 1] - nums[0];

        while(lp < rp) {
            int mid = lp + (rp - lp) / 2;

            if(isValid(mid)) {
                rp = mid;
            } else {
                lp = mid + 1;
            }

           
        }
         return lp;
    }

    public boolean isValid(int num) {

        int index = 0;
        int count = 0;
        while(index < numA.length - 1) {
            if(numA[index + 1] - numA[index] <= num) {
                count++;
                index++;
            }
            index++;
        }
        return (count >= p1);
    }
}