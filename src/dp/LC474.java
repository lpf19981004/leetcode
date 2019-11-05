package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC474 {

    public static void main(String[] args) {
        int ans = new LC474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        System.out.println(ans);
    }

    private int[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(strs, 0, m, n);
    }

    private int dfs(String[] s, int k, int m, int n) {
        if (memo[k][m][n] != -1)
            return memo[k][m][n];
        int ans = 0;
        for (int i = k; i < s.length; i++) {
            // 选择当前字符串
            String str = s[i];
            int M = m;
            int N = n;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    N--;
                } else if (str.charAt(j) == '0') {
                    M--;
                } else {
                    throw new RuntimeException("input data error");
                }
            }
            if (M >= 0 && N >= 0) {
                ans = Math.max(ans, 1 + dfs(s, i + 1, M, N));
            }
        }
        memo[k][m][n] = ans;
        return ans;
    }


    public int findMaxForm2(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int M = 0;
            int N = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    M++;
                } else {
                    N++;
                }
            }
            for (int j = m; j >= M; j--) {
                for (int k = n; k >= N; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - M][k - N]);
                }
            }
        }
        return dp[m][n];
    }

}
