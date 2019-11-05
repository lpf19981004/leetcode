package dp;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC343 {


    public static void main(String[] args) {

        int ans = new LC343().integerBreak2(10);
        System.out.println(ans);

    }


    // 记忆递归解法
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        if (memo[n] != 0)
            return memo[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * dfs(n - i, memo)));
        }
        memo[n] = ans;
        return ans;
    }

    // 动态规划解法
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
        return dp[n];
    }
}
