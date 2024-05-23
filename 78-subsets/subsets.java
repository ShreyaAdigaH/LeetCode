class Solution {
    /**
     * Code works by adding the subsets of below in the given order
     * 1) 0th element
     * 2) 0th 1st element
     * 3) 0th 1st 2nd element
     * .
     * .
     * .
     * n) 0th 1st 2nd ....(n - 1)th element
     * and then backtrack to respective subsets to check other possible combination with it
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    /**
     * Order of addition to the result
     * stand at an element and check all possible combinations of subset with it in forward direction
     * Stand at {1} and call recursion to check possible subsets while standing at 1
     * 1st possible subset {1, 2}
     * stand at 2 and call recursion to check possible subsets while standing at 2
     * 2nd possible subset {1, 2, 3}
     **/

    public void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, result);
            subset.removeLast(); // because you have to remove the last added element to the list to check
                               // for the possible subsets with the list before adding the last element
        }
    }
}