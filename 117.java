class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            Node prev = null;
            while(sz-- > 0) {
                Node node = q.poll();
                if(prev != null) {
                    prev.next = node;
                }
                if(node == null) continue;
                q.add(node.left);
                q.add(node.right);
                prev = node;
            }
        }

        return root;
    }
}
