class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            double len = nodes.size();
            double sum = 0;
            for(int i=0;i<len;i++) {
                TreeNode n = nodes.poll();
                sum += n.val;

                if(n.left != null) nodes.offer(n.left);
                if(n.right != null) nodes.offer(n.right);
            }

            res.add(sum / len);
        }
        return res;
    }
}
