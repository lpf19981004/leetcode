package dp;

/**
 * @author liangpf
 * @Date 2019/10/30
 */
public class LC322 {
    /*
        1, 2, 5  11

          0 1 2 3 4 5 6 7 8 9 10 11
        1 0 1 1 2 4 5 6 7 8 9 10 11

     */

    public static void main(String[] args) {
        int ans = new LC322().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(ans);
    }


    public int coinChange(int[] coins, int amount) {
        int len = amount + 1;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = len;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins)
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
