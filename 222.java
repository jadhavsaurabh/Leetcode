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
// class Solution {
//     public int inOrder(TreeNode node) {
//         if(node != null) {
//             return inOrder(node.left) + inOrder(node.right) + 1;
//         }
//         return 0;
//     }
//     public int countNodes(TreeNode root) {
//         return inOrder(root);
//     }
// }

class Solution {
    public int leftht(TreeNode node) {
        if(node == null) return 0;
        return leftht(node.left) + 1;
    }
    
    public int rightht(TreeNode node) {
        if(node == null) return 0;
        return rightht(node.right) + 1;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = leftht(root.left);
        int right = rightht(root.right);
        
        if(left == right) return (int)Math.pow(2, left + 1) - 1;
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
