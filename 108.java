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


 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int i = 0;
        int j = nums.length;
        if(j == 0) return null;
        int mid = j/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, i, mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, j));

        return node;
    }
}
