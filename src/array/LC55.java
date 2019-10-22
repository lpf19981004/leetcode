package array;

import java.util.Arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author liangpf
 * @date 2019/10/12
 */
public class LC55 {

    public static void main(String[] args) {
        System.out.println(canJump3(new int[]{3,2,1,0,4}));
    }

    /**
     * 递归解法超出时间限制
     * @return
     */
    /*
    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }*/

    /**
     * 解法2
     * 记忆型递归
     * 对于无法到达终点的下标记录为BAD位置
     * 只对好的下标进行跳跃
     * 效率仍然很低
     */

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    static Index[] memo;

    public static boolean  canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public static boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    /**
     * 解法3
     * 动态规划
     * 从后往前判断倒数第二个位置能否到达倒数第一个位置
     * 依次向前类推
     * 如果连倒数第二个都到达不了,那么肯定无法到达最后一个
     * 终点依次向前移动，如果最后终点是起点，那么表示可以到达
     */

    public static boolean canJump3(int[] nums) {

        if (nums == null) {
            return false;
        }
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 逐步向前递推
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }




}
