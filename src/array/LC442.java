package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC442 {


    public static void main(String[] args) {
        LC442 demo = new LC442();
        List<Integer> duplicates = demo.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(duplicates);
    }

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        // 对于出现两次的元素,一个位置存储不了两个元素
        // 如果出现遍历到的元素所应该在的位置已经被置为负数，那么这个元素就是重复元素
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            } else {
                ans.add(Math.abs(num));
            }
        }
        return ans;
    }
}
