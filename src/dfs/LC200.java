package dfs;

/**
 * @author liangpf
 * @date 2019/10/18
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class LC200 {

    public static void main(String[] args) {
        new LC200().numIslands(new char[][]{{'1'},{'1'}});
    }

    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1')
                    ans += dfs(grid, i, j);
            }
        }
        return ans;
    }

    private int dfs(char[][] grid, int x, int y) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[x].length - 1) return 0;
        int res = 0;
        if (grid[x][y] == '1') {
            res++;
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                res += dfs(grid, x + row[i], y + col[i]);
            }
        }
        return res >= 1 ? 1 : 0;
    }
}
