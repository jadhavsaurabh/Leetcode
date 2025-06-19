class Solution {
    public void calculateSum(TreeNode node, boolean[] res, int sum, int target) {
        if (node == null) return;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                res[0] = true;
            }
            return;
        }

        calculateSum(node.left, res, sum + node.val, target);
        calculateSum(node.right, res, sum + node.val, target);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        boolean[] res = new boolean[1];
        calculateSum(root, res, 0, targetSum);
        return res[0];
    }
}
