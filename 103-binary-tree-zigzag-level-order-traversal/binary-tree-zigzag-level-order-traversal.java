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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isLeft = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty() && root != null){
            int size = queue.size();
            Deque<Integer> res = new ArrayDeque<>();
            for(int i = 0; i< size ; i++){
                TreeNode node = queue.poll();
                if(isLeft){
                    res.addLast(node.val);
                }
                else{
                    res.addFirst(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            isLeft = !isLeft;
            result.add(new ArrayList<>(res));
        }
        return result;

    }
}