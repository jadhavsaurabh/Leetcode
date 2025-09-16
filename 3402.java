
class Solution {
    public int minimumOperations(int[][] grid) {
        int res = 0;
        if(grid.length == 1) return 0;


        for(int i=1;i< grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i-1][j] >= grid[i][j]) {
                    res += ( grid[i-1][j] - grid[i][j] + 1);
                    grid[i][j] = grid[i-1][j] + 1;
                }
            }
        }

        return res;
    }
}
