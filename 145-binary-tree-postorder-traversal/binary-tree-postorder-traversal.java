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
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
        if(root == null){
            return ans;
        }
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode peek = stack.peek();

                if(peek.right != null && peek.right != lastVisited){
                    curr = peek.right;
                }
                else{
                    lastVisited = peek;
                    ans.add(lastVisited.val);
                    stack.pop();
                }
            }
        }
        return ans;
    }
}