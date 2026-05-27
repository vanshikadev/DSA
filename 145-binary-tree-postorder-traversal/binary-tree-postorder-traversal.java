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
        TreeNode curr = root;
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                result.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            TreeNode node = stack.pop();
            curr = node.left;
        }
        Collections.reverse(result);
        return result;
    }    
}