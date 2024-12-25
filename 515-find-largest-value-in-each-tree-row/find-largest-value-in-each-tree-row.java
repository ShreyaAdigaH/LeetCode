/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
          List<Integer> res = new ArrayList<>();
        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.add(root);
        if (root == null) {
            return res;
        }
        res.add(root.val);

        while(!treeQ.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int currLevelSize = treeQ.size();

            for(int i = 0; i < currLevelSize; i++) {
                TreeNode curr = treeQ.poll();
                if(curr.left != null) {
                    treeQ.add(curr.left);
                    max = Math.max(max, curr.left.val);
                }

                if(curr.right != null) {
                    treeQ.add(curr.right);
                    max = Math.max(max, curr.right.val);
                }
            }
            res.add(max);
        }
        res.removeLast();
        return res;
    }
}