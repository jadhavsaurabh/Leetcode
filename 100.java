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
    public void inOrder(TreeNode p, TreeNode q, boolean[] res) {
        if(p != null && q == null) {
            res[0] = false;
        }
        if(q != null && p == null) {
            res[0] = false;
        }
        if(p != null && q != null) {
            inOrder(p.left, q.left, res);
            if(p.val != q.val) {
                res[0] = false;
            }
            inOrder(p.right, q.right, res);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] res = {true};
        inOrder(p, q, res);
        
        return res[0];
    }
}
