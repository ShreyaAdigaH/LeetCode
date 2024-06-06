class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
                if(nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        for(int index = 0; index < nums.length; index++) {
            if(nums[index] >= 0) {
                int currentIndex = index;
                int count = 1;
                int successor = nums[index] + 1;
                nums[index] = -1;
                while(currentIndex < nums.length && count < k) {
                    if(nums[currentIndex] == successor) {
                        nums[currentIndex] = -1;
                        successor = successor + 1;
                        count++;
                    } else if (nums[currentIndex] > successor) {
                        return false;
                    }
                    currentIndex++;
                }
                if(count != k)
                    return false;
            }
        }
        return true;
    }
}