package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC287 {

    public static void main(String[] args) {
        LC287 d = new LC287();
        int duplicate = d.findDuplicate(new int[]{2,1,3,4,2});
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1])
                return nums[i];
        }
        return 0;
    }
}
