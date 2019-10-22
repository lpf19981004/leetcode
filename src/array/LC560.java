package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC560 {

    public static void main(String[] args) {
        LC560 d = new LC560();

        int ans = d.subarraySum(new int[]{1, 2, 1, 2, 1}, 3);
        System.out.println(ans);
    }

    /**
     * dp[i] 代表 0～i的和 ， 如果有 dp[j] - dp[i] = k ,则为一个解
     *
     * 子数组的和就简化为了2数之和， 是否存在 i和j， 使得 dp[i] + k = dp[j]
     *
     * @param nums
     * @param k
     * @return
     */

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        //dp[i]表示前i个数的和
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            if (map.containsKey(dp[i] - k))
                ret += map.get(dp[i] - k);
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        return ret;
    }
}
