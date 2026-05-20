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
    class Pair {
        TreeNode node;
        int row;
        int column;

        Pair(TreeNode node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.offer(new Pair(root,0,0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int column = pair.column;
            int row = pair.row;
            TreeNode node = pair.node;

            if(node.left != null){
                queue.offer(new Pair(node.left , row + 1 , column -1));
            }
            if(node.right != null){
                queue.offer(new Pair(node.right , row + 1 , column + 1));
            }
            map.putIfAbsent(column, new TreeMap<Integer,PriorityQueue<Integer>>());
            map.get(column).putIfAbsent(row, new PriorityQueue<Integer>());
            map.get(column).get(row).offer(node.val);
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> que : rows.values()){
                while(!que.isEmpty()){
                    list.add(que.poll());
                }
            }
        result.add(list);
        }
        return result;
    }
}