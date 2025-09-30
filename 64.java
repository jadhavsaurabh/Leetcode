class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];
        // TODO: Can be optimized further if we just initialize last column & row first & run below loop excluding them
        for(int i = r-1;i>=0;i--) {
            for(int j = c-1;j>=0;j--) {
                if(i==r-1 && j==c-1) {
                    dp[i][j] = grid[i][j];
                } else if(i==r-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if(j==c-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
