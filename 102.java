class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<sz;i++) {
                TreeNode node = q.poll();
                if(node != null) {
                    level.add(node.val);
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
