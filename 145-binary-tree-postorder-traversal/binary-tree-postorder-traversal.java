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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.add(curr);
                result.add(curr.val);
                curr = curr.right;
            }
            TreeNode node = stack.pop();
            curr = node.left;
        }
        Collections.reverse(result);
        return result;
    }    
}