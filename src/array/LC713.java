package array;

/**
 * @author liangpf
 * @date 2019/10/18
 * 给定一个正整数数组 nums。
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 * <p>
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 */
public class LC713 {

    public static void main(String[] args) {
        int ans = new LC713().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        System.out.println(ans);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int temp = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            temp *= nums[right];
            while (temp >= k) temp /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

}
