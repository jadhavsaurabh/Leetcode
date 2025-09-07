class Solution {
    public int find(int[] union, int node) {
        if (union[node] == node) return node;
        union[node] = find(union, union[node]); // Path compression
        return union[node];
    }

    public int countComponents(int n, int[][] edges) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }

        for (int[] edge : edges) {
            int parentX = find(union, edge[0]);
            int parentY = find(union, edge[1]);
            union[parentX] = parentY; // Union step
        }

        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(find(union, i));
        }
        return st.size();
    }
}
