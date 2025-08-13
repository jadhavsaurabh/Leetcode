class Codec {
    String SEP = ",";
    String PRE_IN_SEP = "|";

    // Serialize BST to string
    public String serialize(TreeNode root) {
        if (root == null) return "";  // handle empty tree
        StringBuilder preorder = new StringBuilder();
        StringBuilder inorder = new StringBuilder();
        buildPreorder(root, preorder);
        buildInorder(root, inorder);
        return preorder.toString() + PRE_IN_SEP + inorder.toString();
    }

    private void buildPreorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(SEP);
        buildPreorder(node.left, sb);
        buildPreorder(node.right, sb);
    }

    private void buildInorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        buildInorder(node.left, sb);
        sb.append(node.val).append(SEP);
        buildInorder(node.right, sb);
    }

    // Deserialize string back to BST
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null; // handle empty string
        String[] parts = data.split("\\|");
        if (parts.length < 2) return null; // safety check

        String[] preArr = parts[0].split(SEP);
        String[] inArr = parts[1].split(SEP);

        List<Integer> preorder = new ArrayList<>();
        for (String s : preArr) if (!s.isEmpty()) preorder.add(Integer.parseInt(s));

        List<Integer> inorder = new ArrayList<>();
        for (String s : inArr) if (!s.isEmpty()) inorder.add(Integer.parseInt(s));

        return buildTree(preorder, inorder);
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty()) return null;
        int rootVal = preorder.remove(0);
        TreeNode root = new TreeNode(rootVal);
        int idx = inorder.indexOf(rootVal);

        root.left = buildTree(new ArrayList<>(preorder.subList(0, idx)), new ArrayList<>(inorder.subList(0, idx)));
        root.right = buildTree(new ArrayList<>(preorder.subList(idx, preorder.size())), new ArrayList<>(inorder.subList(idx + 1, inorder.size())));
        return root;
    }
}
