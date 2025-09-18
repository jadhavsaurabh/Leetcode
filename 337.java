class Solution {
    public int[] postOrder(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);
        
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = node.val + left[0] + right[0];
        
        return new int[]{notRob, rob};
    }
    
    public int rob(TreeNode root) {
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }
}
