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
 class Pair{
    TreeNode node;
    boolean is_left;
    Pair(TreeNode node , boolean is_left){
        this.node = node;
        this.is_left = is_left;
    }
 }
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(new Pair(curr , true));
                curr = curr.left;
            }
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            boolean is_left = pair.is_left;
            if(is_left){
                stack.push(new Pair(node, false));
                curr = node.right;
            }
            else{
                result.add(node.val);
                curr = null;
            }
        }
        return result;
    }
}