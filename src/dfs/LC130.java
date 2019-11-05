package dfs;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liangpf
 * @Date 2019/10/22
 */
public class LC130 {

    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        new LC130().solve(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int cnt = 0;
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0;i<board.length;i++){
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    map.put(i, j);
                }else {
                    cnt++;
                }
            }
        }
        if (cnt == 0) return;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            dfs(board, entry.getKey(), entry.getValue());
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[x].length - 1) return;
        char ch = board[x][y];
        if (ch == 'O' && x != 0 && x != board.length - 1 && y != 0 && y != board[x].length - 1) {
            board[x][y] = 'X';
            for (int i = 0; i < 4; i++) {
                dfs(board, x + row[i], y + col[i]);
            }
        }
    }
}
