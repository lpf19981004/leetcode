package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC228 {

    public static void main(String[] args) {
        LC228 d = new LC228();
        List<String> list = d.summaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println(list);
    }


    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int length = nums.length;
        if (length == 0) return ans;
        int start = nums[0], end = nums[0];
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                end = nums[i + 1];
            } else {
                if (start == end) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(start + "->" + end);
                }
                start = nums[i + 1];
                end = nums[i + 1];
            }
        }
        if (end > start) {
            ans.add(start + "->" + end);
        }else if (end == start){
            ans.add(String.valueOf(start));
        }
        return ans;
    }
}
