package dfs;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class LC37 {

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    dfs(board, i, j);
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {

        if (board[x][y] != '.') return;
        for (int k = 1; k <= 9; k++) {
            if (check(k, x, y, board)) {
                board[x][y] = (char) (k-'0');
                dfs(board, x+1, y);
            }
            board[x][y] = '.';
        }
    }

    private boolean check(int k, int i, int j, char[][] board) {

        return false;
    }
}
