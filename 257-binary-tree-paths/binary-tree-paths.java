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
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        backtrack(root);
        return result;
    }
    private void backtrack(TreeNode root){
        if(root == null){
            return;
        }
        path.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            result.add(String.join("->",path));
        }
        backtrack(root.left);
        backtrack(root.right);

        path.remove(path.size()-1);
    }
}