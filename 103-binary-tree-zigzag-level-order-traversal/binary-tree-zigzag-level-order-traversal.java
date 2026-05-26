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
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Boolean lefttoright = true;
        if(root == null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i< size ; i++){
                TreeNode node = queue.poll();
                if(lefttoright){
                    res.addLast(node.val);
                }
                else{
                    res.addFirst(node.val);
                }
                if(node.left != null){
                        queue.offer(node.left);
                }
                if(node.right !=null){
                        queue.offer(node.right);
                    }
            }
            list.add(new ArrayList<>(res));
            lefttoright = !lefttoright;
        }
        return list;
    }
}