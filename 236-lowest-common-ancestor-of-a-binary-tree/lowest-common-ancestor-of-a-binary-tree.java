/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }

        int curr = root == p || root == q ? 1 : 0;
        int childCount = dfs(root.left, p, q) + dfs(root.right, p, q);

        if (curr + childCount >= 2 && ans == null) {
            ans = root;
        }

        return curr + childCount;

    }
}