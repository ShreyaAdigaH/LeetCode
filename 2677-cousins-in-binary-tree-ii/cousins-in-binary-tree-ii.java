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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        Queue<TreeNode> treeInQueue = new LinkedList<>();

        treeInQueue.add(root);

        while (!treeInQueue.isEmpty()) {
            int sum = 0;
            int size = treeInQueue.size(); 
            for (int i = 0; i < size; i++) {  
                TreeNode currentNode = treeInQueue.poll();
                sum += currentNode.val;
                if (currentNode.left != null) {
                    treeInQueue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    treeInQueue.add(currentNode.right);
                }
            }
            levelSum.add(sum);
        }

        Queue<Pair<TreeNode, Integer>> nodeChildSum = new LinkedList<>();

        nodeChildSum.add(new Pair<>(root, root.val));

        int level = 0;
        while (!nodeChildSum.isEmpty()) {
            int size = nodeChildSum.size(); 
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> currentNodeSum = nodeChildSum.poll();
                TreeNode currentNode = currentNodeSum.node;
                int currentSum = currentNodeSum.nodeSum;

                currentNode.val = levelSum.get(level) - currentSum; 
                int childSum = 0;
                if (currentNode.left != null) {
                    childSum += currentNode.left.val;
                }
                if (currentNode.right != null) {
                    childSum += currentNode.right.val;
                }
                if (currentNode.left != null) {
                    nodeChildSum.add(new Pair<>(currentNode.left, childSum));
                }
                if (currentNode.right != null) {
                    nodeChildSum.add(new Pair<>(currentNode.right, childSum));
                }
            }
            level++;
        }

        return root;
    }
}

// Custom Pair class to hold node and its child sum
class Pair<A, B> {
    public final A node;
    public final B nodeSum;

    public Pair(A node, B nodeSum) {
        this.node = node;
        this.nodeSum = nodeSum;
    }
}
