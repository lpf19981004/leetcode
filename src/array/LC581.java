package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/25
 */
public class LC581 {
    public static int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(nums);
        int cntStart = 0, cntEnd = 0, start = 0, end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp[i]) {
                cntStart++;
            } else {
                break;
            }
        }
        if (cntStart == nums.length) {
            return 0;
        }
        for (int i = nums.length - 1; i > start; i--) {
            if (nums[i] == temp[i]){
                cntEnd++;
            }else {
                break;
            }
        }
        return nums.length - (cntStart + cntEnd);
    }
}
