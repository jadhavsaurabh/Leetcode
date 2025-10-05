// https://neetcode.io/problems/islands-and-treasure?list=neetcode150
class Solution {
    public void populate(int[][] grid, boolean[][] visited, int distance, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(visited[i][j] || grid[i][j] == -1 || (grid[i][j] == 0 && distance != 0) || grid[i][j] < distance) return;
        
        visited[i][j] = true;
        if(grid[i][j] > distance) {
            grid[i][j] = distance;
        }
        populate(grid, visited, distance + 1, i + 1, j);
        populate(grid, visited, distance + 1, i, j + 1);
        populate(grid, visited, distance + 1, i - 1, j);
        populate(grid, visited, distance + 1, i, j - 1);
        visited[i][j] = false;
    }
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    
                    populate(grid, visited, 0, i, j);
                }
            }
        }
    }
}
