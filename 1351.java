class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0, row = 0, col = grid[0].length -1;
        while(col >= 0 && row < grid.length){
            if(grid[row][col] < 0){
                count += grid.length - row;
                col--;
            }else{
                row++;
            }
        }
        return count;
    }
}
