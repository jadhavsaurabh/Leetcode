class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Clone the first node and put it in the visited map
        Node clone = new Node(node.val);
        visited.put(node, clone);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone and store
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Link the clone of current to the clone of neighbor
                Node clonedCurr = visited.get(curr);
                Node clonedNeighbor = visited.get(neighbor);
                clonedCurr.neighbors.add(clonedNeighbor);
            }
        }

        return visited.get(node);
    }
}
