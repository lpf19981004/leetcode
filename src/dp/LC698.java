package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC698 {

    public static void main(String[] args) {
        boolean ans = new LC698().canPartitionKSubsets(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5);
        System.out.println(ans);
    }


    private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        if (cur == target) {
            // 使用剩下的元素去构建下一个集合
            return backtracking(nums, k-1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur+nums[i] <= target) {
                // 先使用这个数字
                used[i] = true;
                if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
                // 如果无法组合在这里回溯
                used[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum/k) return false;
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum/k, 0, 0, used);
    }



}
