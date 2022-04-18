/**
  Do inorder traversal, have two static vars to store result & current checked number
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
    static int res = 0;
    static int check = 0;
    public void inOrder(TreeNode root, int k) {
        if(root != null) {
            inOrder(root.left, k);
            check++;
            if(k == check) {
                res = root.val;
            }
            inOrder(root.right, k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        check = 0;
        res = 0;
        inOrder(root, k);
        return res;
    }
}
