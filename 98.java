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
    public void inOrder(TreeNode root, boolean[] res, long[] prev) {
        if(root != null) {
            inOrder(root.left, res, prev);
            long curr = root.val;
            if(curr <= prev[0]) {
                res[0] = false;
            }
            prev[0] = curr;
            inOrder(root.right, res, prev);
        }
    }

    public boolean isValidBST(TreeNode root) {
        boolean[] res = {true};
        long[] prev = {Long.MIN_VALUE};
        inOrder(root, res, prev);
        return res[0];
    }
}
