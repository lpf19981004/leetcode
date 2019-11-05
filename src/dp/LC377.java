package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC377 {

    public static void main(String[] args) {
        int ans = new LC377().combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(ans);
    }


    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1)
            return memo[target];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (target - nums[i] < 0) break;
            ans += dfs(nums, target - nums[i]);
        }
        memo[target] = ans;
        return ans;
    }


//    int[] memo;
//    public int combinationSum4(int[] nums, int target) {
//        memo = new int[target+1];
//        Arrays.fill(memo, -1);
//        return backtracking(target,nums);
//    }
//    private int backtracking(int target, final int[] candidates) {
//        if (target == 0) {
//            return 1;
//        }
//        if (memo[target]!=-1)
//            return memo[target];
//        int res = 0;
//        for (int i = 0; i < candidates.length; i++) {
//            if (candidates[i] <= target) {
//                res += backtracking(target - candidates[i], candidates);
//            }
//        }
//        memo[target] = res;
//        return res;
//    }


}
