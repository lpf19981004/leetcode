package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/22
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 */
public class LC494 {

    public static void main(String[] args) {
        int ans = new LC494().findTargetSumWays(new int[]{1}, 1);
        System.out.println(ans);
    }

    private int temp = 0;

    public int findTargetSumWays(int[] nums, int S) {
        temp = S;
        return findTargetSumWays(nums, 0, 0, new ArrayList<>());
    }

    private int findTargetSumWays(int[] nums, int k, int target, List<Integer> list) {
        if (target == temp && list.size() == nums.length) {
            list.remove(list.size() - 1);
            return 1;
        }
        int cnt = 0;
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            list.add(-num);
            int left = findTargetSumWays(nums, i + 1, target - num, list);
            cnt += left;
            list.add(num);
            int right = findTargetSumWays(nums, i + 1, target + num, list);
            cnt += right;
        }
        if (list.size() > 0)
            list.remove(list.size() - 1);
        return cnt;
    }
}
