package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class LC47 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new LC47().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }
    private List<List<Integer>> ans = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return ans;
    }
    private void dfs(int[] nums, int k) {
        if (k == nums.length) {
            List<Integer> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for (int num : nums) {
                list.add(num);
                builder.append(num);
            }
            if (set.add(builder.toString()))
                ans.add(list);
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            dfs(nums, k + 1);
            swap(nums, i, k);
        }
    }
    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}
