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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;

        // Add root (only if it's not a leaf)
        if (!isLeaf(root)) {
            result.add(root.val);
        }

        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

    // ✅ Left Boundary (excluding leaves)
    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        TreeNode curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // ✅ Leaf Nodes (DFS)
    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    // ✅ Right Boundary (excluding leaves, added in reverse)
    private void addRightBoundary(TreeNode node, List<Integer> result) {
        TreeNode curr = node;
        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // Add in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    // ✅ Helper to check leaf
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}