package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/10/30
 */
public class LC300 {

    /*
        最坏的情况下,所有的元素都一样或者是递减排列
        那么此时的最大子序列长度就是1
        一开始 dp[i] = 1
        for(j = i-1 ;j>= 0 ;j--)
            dp[i] = Math.max(1+dp[j],dp[i]);
        10,9,2,5,3,7,101,18
        1  1 1 2 2 3  4   4
     */


    public static void main(String[] args) {
        int ans = new LC300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(ans);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] >= nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
        int ans = 1;
        for (int i = 0; i < dp.length; i++)
            ans = Math.max(ans, dp[i]);
        return ans;
    }
}
