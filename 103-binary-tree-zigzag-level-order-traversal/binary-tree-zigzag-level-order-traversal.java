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
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        boolean left = true;
        if(curr != null){
            queue.offer(curr);
        }
        while(!queue.isEmpty()){
            int size =  queue.size();
            LinkedList<Integer> res = new LinkedList<>();
            for(int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                if(left){
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
            left = !left;
            result.add(new ArrayList<>(res));
        }
        return result;
}
}