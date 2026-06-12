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
    int row;
    int col;
    Pair(TreeNode node , int row , int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new 
        TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        TreeNode curr = root;
        Queue<Pair> queue = new LinkedList<>();
        if(curr == null){
            return result;
        }
        queue.offer(new Pair(curr , 0 ,0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int row = pair.row;
            int col = pair.col;
            map.putIfAbsent(col , new TreeMap<>());
            map.get(col).putIfAbsent(row , new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if(node.left != null){
                queue.offer(new Pair(node.left, row+1 , col-1));
            }
            if(node.right != null){
                queue.offer(new Pair(node.right, row+1 , col+1));
            }
        }

        for (TreeMap<Integer,PriorityQueue<Integer>> col : map.values()){
            List<Integer> res = new ArrayList<>();
            for (PriorityQueue<Integer> row : col.values()){
                while(!row.isEmpty()){
                    res.add(row.poll());
                }
            }
            result.add(new ArrayList<>(res));
        }
        return result;
    }
}