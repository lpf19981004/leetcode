package practice.arr;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/10/31
 */
public class demo2 {
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len - 1;
        int[] temp = Arrays.copyOfRange(nums, 0, len);
        Arrays.sort(nums);
        int max = nums[len - 1];
        int secMax = nums[len - 2];
        if (max >= secMax * 2) {
            for (int i = 0; i < len; i++) {
                if (temp[i] == max) {
                    return i;
                }
            }
        }
        return -1;
    }
}
