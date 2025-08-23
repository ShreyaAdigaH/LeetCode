class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateSubsets(0, nums, curr, res);
        return res;
    }

    public void generateSubsets(int i, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        //base case 
        if(i >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        generateSubsets(i + 1, nums, curr, res);

        curr.remove(curr.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        generateSubsets(i + 1, nums, curr, res);
    }
}