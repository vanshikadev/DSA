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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Deque<List<Integer>> result = new ArrayDeque<>();
        // List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return new ArrayList<>(result);
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0 ; i< size ; i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){

                    queue.offer(node.right);
                }
            }
            result.offerFirst(new ArrayList<>(res));
        }
        return new ArrayList<>(result);
    }
}