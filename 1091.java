class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        q.add(new int[]{0, 0});
        int[][] distance = new int[row][col];
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;

        int[][] directions = {{1,1}, {1,0},{0,1},{1,-1},{-1,0},{0,-1},{-1,-1},{-1,1}};

        distance[0][0] = 1;
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] popped = q.poll();
            // System.out.println("popped" + Arrays.toString(popped));
            for(int[] direction: directions) {
                int x = popped[0] + direction[0];
                int y = popped[1] + direction[1];

                if(x >= 0 && y >= 0 && x < row && y < col && !visited[x][y] && grid[x][y] == 0) {
                    distance[x][y] = distance[popped[0]][popped[1]] + 1;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        // System.out.println(Arrays.deepToString(distance));
        return distance[row - 1][col - 1] == 0 ? -1 : distance[row - 1][col - 1];
    }
}
