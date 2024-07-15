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
    public TreeNode createBinaryTree(int[][] description) {
              TreeNode[] nodeValues = new TreeNode[100001];
        int[] hasParent = new int[100001];
        for(int edge = 0; edge < description.length; edge++) {
            if(nodeValues[description[edge][0]] == null) {
                nodeValues[description[edge][0]] = new TreeNode(description[edge][0]);
            }
            if(nodeValues[description[edge][1]] == null) {
                nodeValues[description[edge][1]] = new TreeNode(description[edge][1]);
            }
            hasParent[description[edge][1]] = 1;
            if(description[edge][2] == 1) {
                nodeValues[description[edge][0]].left = nodeValues[description[edge][1]];
            } else {
                nodeValues[description[edge][0]].right = nodeValues[description[edge][1]];
            }
        }
        
        for(int node = 0; node < description.length; node++) {
            if(hasParent[description[node][0]] == 0) {
                return nodeValues[description[node][0]];
            }
        }
        return null;
    }
}