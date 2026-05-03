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
        return compare(p,q);   
    }
    public boolean compare(TreeNode p, TreeNode q){
        boolean left;
        boolean right;
        if( p == null && q == null ){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        else{
            left = compare(p.left, q.left);
            right = compare(p.right,q.right);
        }
        return (left && right);
    }
}