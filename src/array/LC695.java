package array;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC695 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int res = new LC695().maxAreaOfIsland(grid);
        System.out.println("ans = " + res);
    }
    private int[] row = new int[]{1, -1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(dfs(grid, i, j), ans);
                }
            }
        }
        return ans;
    }
    private int dfs(int[][] grid, int x, int y) {
        // 检查越界情况
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[x].length - 1) return 0;
        if (grid[x][y] == 0) return 0;
        int cnt = 0;
        if (grid[x][y] == 1) {
            cnt++;
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++)
                cnt += dfs(grid, x + row[i], y + col[i]);
        }
        return cnt;
    }

}
