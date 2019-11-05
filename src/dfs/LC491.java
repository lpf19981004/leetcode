package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/22
 */
public class LC491 {

    public static void main(String[] args) {
        List<List<Integer>> res = new LC491().findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int k, List<Integer> list) {

        for (int i = k ; i < nums.length; i++) {
            list.add(nums[k]);
            if (nums[i+1] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                if (list.size() >= 2 && list.size() <= nums.length) {
                    ans.add(new ArrayList<>(list));
                }
                dfs(nums, i + 1, list);
            }
        }
        if (list.size() > 0)
            list.remove(list.size() - 1);
    }
}
