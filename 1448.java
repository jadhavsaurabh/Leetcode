class Solution {
    static int count = 0;
    public static void inOrder(TreeNode node, int max) {
        if(node == null) return;
        if(node.val >= max) {
            count++;
            max = node.val;
        }
        inOrder(node.left, max);
        inOrder(node.right, max);
    }

    public int goodNodes(TreeNode root) {
        count = 0;
        inOrder(root, -10001);
        return count;
    }
}
