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
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        while(true){
            if(root != null){
                stack.add(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                TreeNode node =stack.pop();
                ans.add(node.val);
                root=node.right;
            }
        }
        return ans;
    }
}