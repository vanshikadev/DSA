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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( q == null && p == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(isSameTree(p.right,q.right) && isSameTree(p.left,q.left)){
            if(p.val == q.val){
            return true;
        }
        }
        return false;
    }
}