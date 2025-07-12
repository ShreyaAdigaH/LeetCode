class FindSumPairs {

    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> nums2Freq = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2) {
            if(nums2Freq.containsKey(num)) {
                nums2Freq.replace(num, nums2Freq.get(num) + 1);
            } else {
                nums2Freq.put(num, 1);
            }
        }
    }

    public void add(int index, int val) {
        nums2Freq.replace(nums2[index], nums2Freq.get(nums2[index]) - 1); 
        nums2[index] += val;
        if(nums2Freq.containsKey(nums2[index])) {
                nums2Freq.replace(nums2[index], nums2Freq.get(nums2[index]) + 1);
            } else {
                nums2Freq.put(nums2[index], 1);
            }
    }

    public int count(int tot) {
        int pairs = 0;
        for (int num : nums1) {
            if (num < tot) {
                int diff = tot - num;

                if (nums2Freq.containsKey(diff)) {
                    pairs += nums2Freq.get(diff);
                }
            }
        }
        return pairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */