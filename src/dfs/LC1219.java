package dfs;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC1219 {

    public static void main(String[] args) {
        LC1219 demo = new LC1219();
        int gold = demo.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}});
        System.out.println(gold);
    }

    private int M, N;

    public int getMaximumGold(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        int ans = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, DFS(grid, i, j));
                }
            }
        }
        return ans;
    }

    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0)
            return 0;
        int v = grid[i][j];
        grid[i][j] = 0;
        int ret = 0;
        for (int[] dir : dirs) {
            int nR = i + dir[0], nC = j + dir[1];
            ret = Math.max(ret, v + DFS(grid, nR, nC));
        }
        grid[i][j] = v;
        return ret;
    }

}
