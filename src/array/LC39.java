package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/14
 */
public class LC39 {


    public static void main(String[] args) {
        LC39 demo = new LC39();
        List<List<Integer>> list = demo.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对数组排序在进行深搜时可以提前结束
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new LinkedList<>());
        return ans;
    }

    private void combinationSum(int[] candidates, int target, int index, LinkedList<Integer> temp) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            temp.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, temp);
            temp.removeLast();
        }
    }
}
