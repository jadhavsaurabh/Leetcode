class Solution {
    public void convert(TreeNode node, TreeNode[] list) {
        if (node == null) return;

        list[0].right = new TreeNode(node.val);
        list[0] = list[0].right;

        convert(node.left, list);
        convert(node.right, list);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode dummy = new TreeNode(0);
        TreeNode[] list = new TreeNode[]{dummy};

        convert(root, list);

        root.left = null;
        root.right = dummy.right.right;
    }
}
