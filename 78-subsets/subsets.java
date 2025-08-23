class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateSubsets(0, nums, curr, res);
        return res;
    }

    public void generateSubsets(int i, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        //base case 
        if(i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        generateSubsets(i + 1, nums, curr, res);

        curr.remove(curr.size() - 1);
        generateSubsets(i + 1, nums, curr, res);
    }
}