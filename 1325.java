class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        if(root.left == null && root.right == null && root.val == target) return null;
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);

        if(left == null && right == null && root.val == target) return null;
        TreeNode res = new TreeNode(root.val);
        res.left = left;
        res.right = right;
        return res;
    }
}
