/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.add(root);
        int totalSwaps = 0;
        while (!treeQ.isEmpty()) {
            List<TreeNode> levelNodes = new ArrayList<>();

            int levelSize = treeQ.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = treeQ.poll();

                if (curr.left != null) {
                    levelNodes.add(curr.left);
                    treeQ.add(curr.left);

                }
                if (curr.right != null) {
                    levelNodes.add(curr.right);
                    treeQ.add(curr.right);

                }
            }
            totalSwaps += sortLevel(levelNodes);
        }
        return totalSwaps;
    }

    public static int sortLevel(List<TreeNode> levelNodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] list = new int[levelNodes.size()];
        int size = levelNodes.size();

        for (int i = 0; i < size; i++) {
            int value = levelNodes.get(i).val;
            map.put(value, i); // Map value to its index
            list[i] = value; // Copy values into an array for sorting
        }

        Arrays.sort(list); // Sort the values to determine the target order
        int swaps = 0;

        for (int i = 0; i < list.length; i++) {
            int currNodeVal = levelNodes.get(i).val;

            if (currNodeVal != list[i]) {
                swaps++;

                int actualIndex = map.get(list[i]);

                levelNodes.get(actualIndex).val = currNodeVal;
                levelNodes.get(i).val = list[i];

                map.put(currNodeVal, actualIndex);
                map.put(list[i], i);
            }
        }

        return swaps;
    }
}