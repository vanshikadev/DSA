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
    class Tuple {
        TreeNode node;
        int col;
        int row;
        Tuple(TreeNode node , int col, int row){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer , TreeMap<Integer,PriorityQueue<Integer>>> map = new       TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){return result;}

        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            Tuple tp = queue.poll();
            int row = tp.row;
            int col = tp.col;
            TreeNode node = tp.node;

            //add col if not present
            map.putIfAbsent(col, new TreeMap<>());

            //add row if not present
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            //add node
            map.get(col).get(row).offer(node.val);

            if(node.left != null){
                queue.offer(new Tuple(node.left, col-1 , row + 1));
            }
             if(node.right != null){
                queue.offer(new Tuple(node.right, col+1 , row + 1));
            }

        }

        for(TreeMap<Integer,PriorityQueue<Integer>> x: map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> y : x.values()){
                while(!y.isEmpty()){
                    temp.add(y.poll());
                }
            }
            result.add(temp);
        }
        return result;
    }
}