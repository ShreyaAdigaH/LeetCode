class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    public int binarySearch(int start, int end, int[] nums, int target) {
        // if middle pointer is within decreasing subarray
        // L > M
        if(end < start) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[start] <= nums[mid]) {
            if(target >= nums[start] && target < nums[mid]) {
                return binarySearch(start, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, end, nums, target);
            }
        } else {
            if(target <= nums[end] && target > nums[mid]) {
                return binarySearch(mid + 1, end, nums, target);
            } else {
                return binarySearch(start, mid - 1, nums, target);
            }
        }

    }
}