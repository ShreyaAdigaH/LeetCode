class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        /* Brute force*/

        //   Arrays.sort(nums); // 0, 1, 4, 4, 5, 7
        // long count = 0;

        // for(int i = 0; i < nums.length; i++) {
        //     long lowest = Long.MIN_VALUE;
        //     long highest = Long.MAX_VALUE;
        //     if(nums[i] <= lower) {
        //         lowest = lower - nums[i];
        //     }
        //     if(nums[i] <= upper) {
        //         highest = upper - nums[i];
        //     }
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(highest != Long.MAX_VALUE && nums[j] <= highest) {
        //             if(lowest != Long.MIN_VALUE && nums[j] >= lowest) {
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;
      Arrays.sort(nums); // 0, 1, 4, 4, 5, 7
        long count = 0;
          for(int i = 0; i < nums.length; i++) {
            int least = lower - nums[i];
            int beginIndex = binarySearch(least, nums, i + 1);

            int highest = upper - nums[i];
            int lastIndex = binarySearch(highest + 1, nums, i + 1);

            count += (lastIndex - beginIndex);
        }

        return count;
    }

    //0, 1, 2, 4, 4, 5, 7
    public static int binarySearch(int num, int[] nums, int startIdx) {
        int endIdx = nums.length - 1;

        while (startIdx <= endIdx) {
            int mid = startIdx + (endIdx - startIdx) / 2;

            if (nums[mid] < num) {
                startIdx = mid + 1;
            } else {
                endIdx = mid - 1;
            }
        }

        return startIdx; 
    }
}