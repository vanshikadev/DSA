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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> temp = new Stack<>();
        if(root == null){return ans;}
        temp.add(root);
        while(!temp.isEmpty()){
            TreeNode node = temp.pop();
            ans.add(node.val);
            if(node.right != null){
                temp.add(node.right);
            }
            if(node.left != null){
                temp.add(node.left);
            }

        }
        return ans;
    }
}