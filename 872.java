class Solution {
    public static void preOrder(TreeNode node, List l) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                l.add(node.val);
            }
            
            preOrder(node.left, l);
            preOrder(node.right, l);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        preOrder(root1, l1);
        preOrder(root2, l2);

        return l1.equals(l2);
    }
}
