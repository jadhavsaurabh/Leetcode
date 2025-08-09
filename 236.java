class Solution {

    public void findPath(TreeNode node, int p, int q, ArrayList<TreeNode> path, ArrayList<TreeNode> pPath, ArrayList<TreeNode> qPath) {
        if(node == null) return;
        //System.out.println("node" + node.val);
        path.add(node);
        if(node.val == p && pPath.isEmpty()) {

           // System.out.println("Seeting p path" + path.toString());
            pPath.clear();
            pPath.addAll(path);
        }
        if(node.val == q && qPath.isEmpty()) {
            //System.out.println("Seeting q path" + path.toString());
            qPath.clear();
            qPath.addAll(path);
        }

        findPath(node.left, p, q, path, pPath, qPath);
        findPath(node.right, p, q, path, pPath, qPath);
        path.removeLast();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pPath = new ArrayList<>();
        ArrayList<TreeNode> qPath = new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();

        findPath(root, p.val, q.val, path, pPath, qPath);

        TreeNode prev = root;
        for(int i=1;i<Math.min(pPath.size(), qPath.size());i++) {
            //System.out.println(pPath.get(i).val);
            //System.out.println(qPath.get(i).val);
            if(!Objects.equals(pPath.get(i).val, qPath.get(i).val)) {
                break;
            }

            prev = pPath.get(i);
        }

        return prev;
    }
}
