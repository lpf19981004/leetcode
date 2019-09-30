package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/25
 */
public class LC628 {

    public static void main(String[] args) {

    }


    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int leftMax = nums[0]*nums[1]*nums[len-1];
        int rightMax = nums[len-1]*nums[len-2]*nums[len-3];
        return Math.max(leftMax,rightMax);
    }
}
