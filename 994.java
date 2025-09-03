class Solution {

    public void dfs(int[][] grid, int[][] distanceMat, int i, int j, int distance, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;

        if (grid[i][j] == 0) return; // empty cell
        if (visited[i][j]) return;   // avoid infinite recursion

        // if we already have a shorter distance, stop
        if (distance >= distanceMat[i][j]) return;

        distanceMat[i][j] = distance;
        visited[i][j] = true;

        dfs(grid, distanceMat, i + 1, j, distance + 1, visited);
        dfs(grid, distanceMat, i - 1, j, distance + 1, visited);
        dfs(grid, distanceMat, i, j + 1, distance + 1, visited);
        dfs(grid, distanceMat, i, j - 1, distance + 1, visited);

        visited[i][j] = false; // backtrack for other paths
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] distance = new int[rows][cols];

        // initialize distances to INF
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        // run DFS from every rotten orange
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    boolean[][] visited = new boolean[rows][cols];
                    dfs(grid, distance, i, j, 0, visited);
                }
            }
        }

        // check result
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (distance[i][j] == Integer.MAX_VALUE) return -1; // unreachable fresh orange
                    max = Math.max(max, distance[i][j]);
                }
            }
        }
        return max;
    }
}
