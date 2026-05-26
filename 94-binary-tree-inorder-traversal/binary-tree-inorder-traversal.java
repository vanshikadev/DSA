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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeNode curr = root;
        TreeNode visited = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null && node.right != visited){
                curr = node.right;
            }
            else{
                visited = node;
            }
        }
        return result;
    }
}