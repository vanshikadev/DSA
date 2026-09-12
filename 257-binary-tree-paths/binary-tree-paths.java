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
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        backtrack(root,path);
        return result;
    }
    private void backtrack(TreeNode root, List<Integer>  path){
        if(root == null){
            return;
        }
        path.add(root.val);
       if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    sb.append("->");
                }
                sb.append(path.get(i));
            }
            result.add(sb.toString());
            path.remove(path.size() - 1);
            return;
        }
        backtrack(root.left,path);
        backtrack(root.right,path);
        path.remove(path.size()-1);
    }
}