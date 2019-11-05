package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC576 {

    public static void main(String[] args) {
        int ans = new LC576().findPaths(8, 50, 23, 5, 26);
        System.out.println(ans);
    }

    // 表示上下左右四个方向
    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};
    // 记忆化递归
    private int[][][] memo;
    // mod
    private int mod = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        memo = new int[m + 1][n + 1][N + 1];
        for (int a = 0; a < m; a++)
            for (int b = 0; b < n; b++)
                Arrays.fill(memo[a][b], -1);
        return dfs(m, n, N, i, j, 0);
    }

    // 搜索格子
    private int dfs(int m, int n, int N, int i, int j, int k) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return 1;
        if (k == N) return 0;
        if (memo[i][j][k] != -1) return memo[i][j][k];
        int ans = 0;
        for (int cnt = 0; cnt < 4; cnt++) {
            ans += dfs(m, n, N, i + row[cnt], j + col[cnt], k + 1);
            ans %= mod;
        }
        memo[i][j][k] = ans;
        return ans;
    }

}
