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
    public void add(int[] sum, TreeNode root, boolean left) {
            if(root.left == null && root.right == null) {
                if(left) {
                    sum[0] += root.val;
                }
            } else {
                if(root.left != null) {
                    add(sum, root.left, true);
                }
                if(root.right != null) {
                    add(sum, root.right, false);
                }
            }
        }
        public int sumOfLeftLeaves(TreeNode root) {
            int[] sum = new int[1];
            add(sum, root, false);
            return sum[0];
        }
}
