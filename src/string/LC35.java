package string;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/21
 */
public class LC35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int res = searchInsert(nums, 5);
        System.out.println(res);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] <= target) {
                    return i + 1;
                }
            }
        }
        return nums[0] > target ? 0 : index;
    }
}
