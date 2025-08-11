class Solution {

    public boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return false;
        if(word.charAt(idx) == board[i][j] && idx == word.length() - 1) return true;
        if(word.charAt(idx) != board[i][j]) return false;

        visited[i][j] = true;
        boolean right = dfs(board, i, j + 1, word, idx + 1, visited);
        boolean up = dfs(board, i - 1, j, word, idx + 1, visited);
        boolean left = dfs(board, i , j - 1, word, idx + 1, visited);
        boolean down = dfs(board, i + 1, j , word, idx + 1, visited);
        
        visited[i][j] = false;
        return right || up || left || down;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(word.charAt(0) == board[i][j] && dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
