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
    
    public int maxDepth = 0;
    public int sum = 0;

    public void getMaxDepth(TreeNode root, int[] cDepth) {
        if(root == null) cDepth[0]--;
        else {
            cDepth[0]++;
            getMaxDepth(root.left, cDepth);
            if(cDepth[0] >= maxDepth) {
                maxDepth = cDepth[0];
            }
            cDepth[0]++;
            getMaxDepth(root.right, cDepth);
            cDepth[0]--;
        }
    }

    public void getSMaxDepth(TreeNode root, int[] cDepth) {
        if(root == null) cDepth[0]--;
        else {
            cDepth[0]++;
            getSMaxDepth(root.left, cDepth);
            if(cDepth[0] == maxDepth) {
                sum += root.val;
            }
            cDepth[0]++;
            getSMaxDepth(root.right, cDepth);
            cDepth[0]--;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        int[] cDepth = {0};
        getMaxDepth(root, cDepth);
        cDepth[0] = 0;
        getSMaxDepth(root, cDepth);
        int res = sum;
        sum = 0;
        maxDepth = 0;
        return res;
    }
}
