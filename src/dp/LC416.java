package dp;

import array.LC41;

/**
 * @author liangpf
 * @Date 2019/11/4
 * <p>
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class LC416 {

    public static void main(String[] args) {
        boolean ans = new LC416().canPartition(new int[]{1, 5, 11, 5});
        System.out.println(ans);
    }

    public boolean canPartition(int[] nums) {
        /*
            首先对问题进行分析：
                如果想要把一个数组拆分成两个相等的部分,那么数组两部分的值相等，都等于sum/2
                如果sum/2不能除尽的话，则不可能分割成两个完全相等的部分,直接return false
            如果一个数就可以装满背包,那么把这个格子置为true,如果不能装满，就要看加上这个数
            和之前的（C-num[i]）能不能装满
            状态转移方程：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
         */
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        // 我们就是要看从数组中调出一部分元素能不能填满这个target容量的背包
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        // 初始化背包的第一行
        for (int i = 0; i < target + 1; i++) {
            // 一开始我们只有第一号物品
            if (nums[0] == i) {
                // 这个物品可以装满容量为i的背包
                dp[0][i] = true;
                break;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < target + 1; j++) {
                // 先看没有i号物品的时候能不能填充容量为j的背包
                dp[i][j] = dp[i - 1][j];
                // 如果背包还能装得下
                if (j >= nums[i]) {
                    // 装j号物品和不装j号物品 任意一个能装的下都认为可以装下
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[len - 1][target];
    }
}
