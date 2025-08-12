class BSTIterator {
    ArrayList<Integer> ls;
    int i;
    public BSTIterator(TreeNode root) {
        ls = new ArrayList<>();
        inOrder(root);
        i = 0;
    }
    
    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        ls.add(node.val);
        inOrder(node.right);
    }

    public int next() {
        return ls.get(i++);
    }

    public boolean hasNext() {
        return i < ls.size();
    }
}
