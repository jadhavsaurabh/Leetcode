class Solution {
    private int find(int[] dsuf, int v) {
        if (dsuf[v] == -1) 
            return v;
        return dsuf[v] = find(dsuf, dsuf[v]); // Path Compression
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] dsuf = new int[n + 1];
        Arrays.fill(dsuf, -1);

        for (int[] edge : edges) {
            int parentX = find(dsuf, edge[0]);
            int parentY = find(dsuf, edge[1]);

            if (parentX == parentY) // Redundant Edge
                return edge;
            else // Take Union
                dsuf[parentX] = parentY;
        }
        return new int[]{0, 0};
    }
}
