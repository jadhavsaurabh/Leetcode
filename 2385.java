class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> childMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode startNode = null;

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.val == start) {
                startNode = node;
            }

            if (node.left != null) {
                childMap.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                childMap.put(node.right, node);
                q.add(node.right);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> bfs = new LinkedList<>();

        bfs.add(startNode);
        visited.add(startNode);

        int time = -1;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode node = bfs.poll();

                if (node.left != null && visited.add(node.left)) {
                    bfs.add(node.left);
                }

                if (node.right != null && visited.add(node.right)) {
                    bfs.add(node.right);
                }

                if (childMap.containsKey(node) && visited.add(childMap.get(node))) {
                    bfs.add(childMap.get(node));
                }
            }
        }

        return time;
    }
}
