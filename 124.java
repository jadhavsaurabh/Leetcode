class Solution {
    public int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, maxPathSum(root.left, max));   // ignore negatives
        int rightMax = Math.max(0, maxPathSum(root.right, max)); // ignore negatives

        // update global max using root + left + right
        max[0] = Math.max(max[0], leftMax + rightMax + root.val);

        // return best downward path
        return root.val + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = root.val;
        maxPathSum(root, max);
        return max[0];
    }
}
