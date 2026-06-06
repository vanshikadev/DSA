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
        Stack<Pair<TreeNode,Boolean>> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(new Pair<>(curr,true));
                curr = curr.left;
            }
            else{
                Pair<TreeNode, Boolean> pair = stack.pop();
                TreeNode node = pair.getKey();
                Boolean isLeft = pair.getValue();

                if(isLeft){
                    stack.push(new Pair<>(node,false));
                    curr = node.right;
                }
                else{
                    result.add(node.val);
                    curr = null;
                }

            }
        }
        return result;
    }
}