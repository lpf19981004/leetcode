package dp;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/10/30
 */
public class LC213 {
    /*
        1,2,3,1
        不只是相邻的房子不能挨着，首位的房子也不能挨着
        f(0) = nums[0];
        f(1) = max(nums[0],nums[1]);
        f(2) = max(nums[0],num[1],nums[2])
        f(3) = nums[3] + f(n-2) , f(n-2)
        f(n) = max(nums[n] + nums[n-2], f(n-1))

     */

    public static void main(String[] args) {
        int res = new LC213().rob(new int[]{2,3,2});
        System.out.println(res);
    }

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }


}
