/*
1) Start from edge nodes & apply dfs and mark visited true only if height is more than equal to prev
2) intersection of visited of both oceans
*/
class Solution {
    
    public void dfs(int r,int c,int[][] visited,int prevHeight,int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        if(r < 0 || c < 0 || r == row || c == col) return;

        if(visited[r][c] == 1 || prevHeight > heights[r][c]) return;
        visited[r][c] = 1;
        
        dfs(r + 1, c, visited, heights[r][c], heights);
        dfs(r - 1, c, visited, heights[r][c], heights);
        dfs(r, c + 1, visited, heights[r][c], heights);
        dfs(r, c - 1, visited, heights[r][c], heights);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        int[][] pac = new int[row][col];
        int[][] atl = new int[row][col];

        for(int i=0;i<row;i++) {
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, col - 1, atl, heights[i][col - 1], heights);
        }
        for(int i=0;i<col;i++) {
            dfs(0, i, pac, heights[0][i], heights);
            dfs(row - 1, i, atl, heights[row - 1][i], heights);
        }
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(pac[i][j] == 1 && atl[i][j] == 1) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    res.add(tempList);
                }
            }
        }
        return res;
    }
}
