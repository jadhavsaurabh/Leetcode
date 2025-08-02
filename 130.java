class Solution {
    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        
        if(board[i][j] == 'X') return;
        if(board[i][j] == 'O') {
            board[i][j] = 'T';
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }
    }

    public void solve(char[][] board) {
        // top row
        for(int i=0;i<board[0].length;i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }
        }
        // bottom row
        for(int i=0;i<board[0].length;i++) {
            if(board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        // 1st col
        for(int i=1;i<board.length - 1;i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        // last col
        for(int i=1;i<board.length - 1;i++) {
            if(board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for(int i=0;i< board.length;i++) {
            for(int j=0;j< board[0].length;j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
