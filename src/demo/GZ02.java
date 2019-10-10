package demo;

import java.util.Scanner;

/**
 * @author liangpf
 * @date 2019/10/9
 */
public class GZ02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int fun = fun(n, new int[]{1, 2, 5, 10});
        System.out.println(fun);
        scanner.close();
    }

    static int fun(int n, int[] coins) {
        int[][] dp = new int[coins.length][n + 1];
        for (int i = 0; i < 4; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n + 1; j++)
            dp[0][j] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int k = 0; k <= j / coins[i]; k++) {
                    dp[i][j] += dp[i-1][j - k * coins[i]]%1000000007;
                }
            }
        }
        return dp[coins.length-1][n]%1000000007;
    }

}
