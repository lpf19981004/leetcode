package dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC673 {

    /*
        673. 最长递增子序列的个数
        给定一个未排序的整数数组，找到最长递增子序列的个数。

        示例 1:
        输入: [1,3,5,4,7]
        输出: 2
        解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。

        示例 2:
        输入: [2,2,2,2,2]
        输出: 5
        解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
     */
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);//找出最长递增子序列的长度是多少
        }
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new LC673().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        System.out.println(ans);
    }
}
