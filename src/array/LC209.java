package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangpf
 * @date 2019/10/16
 */
public class LC209 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};
        LC209 demo = new LC209();
        int i = demo.minSubArrayLen(11, nums);
        System.out.println(i);

    }

    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = dp.length - 1; i >= 0; i--) {
            int temp = dp[i] - s;
            if (temp < 0) break;
            int index = search(dp, temp);
            ans = Math.min((i - index), ans);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    private int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                while (nums[++mid] < target) { }
                return mid - 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public int minSubArrayLen2(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(left <= right && sum >= s){
                res = Math.min(res,right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
