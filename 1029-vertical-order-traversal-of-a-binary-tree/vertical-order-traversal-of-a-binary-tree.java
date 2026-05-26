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
    class Pair{
        TreeNode node;
        int row;
        int col;
        Pair(TreeNode node , int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> rowcolmap = new TreeMap<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,0,0));
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int row = pair.row;
            int col = pair.col;
            TreeNode node = pair.node;
            rowcolmap.putIfAbsent(col,new TreeMap<Integer,PriorityQueue<Integer>>());
            rowcolmap.get(col).putIfAbsent(row, new PriorityQueue<Integer>());
            rowcolmap.get(col).get(row).offer(node.val);
            if(node.left != null){
                stack.push(new Pair(node.left, row+1, col-1));
            }
            if(node.right != null){
                stack.push(new Pair(node.right, row+1, col+1));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> row : rowcolmap.values()){
            List<Integer> res = new ArrayList<>();
            for( PriorityQueue<Integer> pq : row.values()){
                while(!pq.isEmpty()){
                    res.add(pq.poll());
                }
            }
            result.add(new ArrayList<>(res));
        }
        return result;
    }
}