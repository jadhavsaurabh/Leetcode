class Solution {
    public boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(neighbor, node, visited, adj))
                    return false;
            } else if (neighbor != parent) {
                // If visited neighbor isn't parent → cycle found
                return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Build adjacency list (undirected)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // Check for cycles starting from node 0
        if (!dfs(0, -1, visited, adj)) return false;

        // Check if all nodes were visited (connected graph)
        for (boolean v : visited)
            if (!v) return false;

        return true;
    }
}
