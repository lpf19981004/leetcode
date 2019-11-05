package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC688 {


    private int[] row = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    private int[] col = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
    private double[][][] memo;

    public double knightProbability(int N, int K, int r, int c) {
        memo = new double[K+1][N][N];
        for (double[][] doubles : memo) {
            for (double[] aDouble : doubles) {
                Arrays.fill(aDouble, -1.0);
            }
        }
        return dfs(N, K, r, c);
    }
    private double dfs(int n, int k, int x, int y) {
        // 跳出了棋盘
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1) {
            return 0;
        }
        if (k == 0) {
            // 成功跳满N步没有出棋盘
            return 1.0;
        }
        if (memo[k][x][y] != -1.0) return memo[k][x][y];
        double ans = 0;
        for (int i = 0; i < 8; i++) {
            ans += dfs(n, k - 1, x + row[i], y + col[i]);
        }
        memo[k][x][y] = ans / 8.0;
        return memo[k][x][y];
    }

    public static void main(String[] args) {
        double v = new LC688().knightProbability(3, 2, 0, 0);
        System.out.println(v);
    }
}
