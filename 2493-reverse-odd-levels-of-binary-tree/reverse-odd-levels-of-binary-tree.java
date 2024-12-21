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
    public TreeNode reverseOddLevels(TreeNode root) {
       Queue<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        int level = 0;
        List<TreeNode> levelNodes;
        while(!tree.isEmpty()) {
            levelNodes = new ArrayList<>();
            int treeLen = tree.size();

            for(int i = 0; i < treeLen; i++) {
                TreeNode curr = tree.poll();
                levelNodes.add(curr);
                if(curr.left != null) {
                    tree.add(curr.left);

                }
                if(curr.right != null) {
                    tree.add(curr.right);
                }
            }

            if(level % 2 == 1) {
                int left = 0;
                int right = treeLen - 1;

                while(left < right) {
                    int currNodeVal = levelNodes.get(left).val;
                    levelNodes.get(left).val  = levelNodes.get(right).val;
                    levelNodes.get(right).val = currNodeVal;
                    left++;
                    right--;
                }
            }
            level += 1;
        }
        return root;
    }
}