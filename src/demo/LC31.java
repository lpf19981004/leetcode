package demo;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/18
 */
public class LC31 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        int index1 = -1, index2 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index1 = i - 1;
                index2 = i;
                break;
            }
        }
        if (index1 == -1) {
            int start = 0, end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
            return;
        }

        for (int i = index2; i < nums.length; i++) {
            if (nums[i] > nums[index1])
                index2 = i;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        int start = index1 + 1, end = nums.length - 1;
        while (start < end) {
            int tem = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tem;
        }
    }
}
