package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC467 {

    public static void main(String[] args) {
        int ans = new LC467().findSubstringInWraproundString("aca");
        System.out.println(ans);
    }


    public int findSubstringInWraproundString(String p) {
        /*
            寻找子串中最长连续上升的子序列的长度
         */
        int len = p.length();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (p.charAt(i) > p.charAt(j)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < len + 1; i++) {
            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
