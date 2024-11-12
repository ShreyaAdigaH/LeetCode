class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1p = m - 1;
        int num2p = n - 1;
        int fillP = nums1.length - 1;
        while (num1p >= 0 && num2p >= 0) {
            if (nums2[num2p] >= nums1[num1p]) {
                nums1[fillP--] = nums2[num2p--];
            } else {
                nums1[fillP--] = nums1[num1p--];
            }
        }

        while (num2p >= 0) {
            nums1[fillP--] = nums2[num2p--];
        }

    }
}