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
    public void inOrder(TreeNode root, ArrayList<Integer> nums) {
        if(root != null) {
            inOrder(root.left, nums);
            nums.add(root.val);
            inOrder(root.right, nums);
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        inOrder(root, nums);
        System.out.println(nums);
        
        TreeNode res = new TreeNode(nums.get(0));
        TreeNode prev = res;
        for(int i=1;i<nums.size();i++) {
            TreeNode temp = new TreeNode(nums.get(i));
            prev.right = temp;
            prev = prev.right;
        }
        return res;
    }
}
