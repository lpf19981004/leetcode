package array;

import java.util.*;

/**
 * @author liangpf
 * @date 2019/10/14
 */
public class LC90 {

    public static void main(String[] args) {
        LC90 demo = new LC90();
        List<List<Integer>> lists = demo.subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
