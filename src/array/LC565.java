package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangpf
 * @date 2019/10/17
 */
public class LC565 {

    public static void main(String[] args) {
        int res = new LC565().arrayNesting2(new int[]{5,4,0,3,1,6,2});
        System.out.println(res);
    }


    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, s = 0; i < nums.length; ) {
            if (set.add(nums[i])) {
                cnt++;
                i = nums[i];
            } else {
                ans = Math.max(cnt, ans);
                cnt = 0;
                i=++s;
            }
        }
        return ans;
    }

    // 5,4,0,3,1,6,2
    public int arrayNesting2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int start = nums[i], count = 0;
                while (nums[start] != -1) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = -1;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
