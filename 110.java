class Solution {
    public int height(TreeNode node, boolean[] res) {
        if(node == null){
            return 0;
        }
        int left = height(node.left, res);
        int right = height(node.right, res);
        if(Math.abs(left - right) > 1) {
            res[0] = true;
        }
        return Math.max(left,right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        height(root, res);
        return !res[0];
    }
}
