package demo;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC40 {


    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum2(double[] candidates, int begin, int len, double residue, Stack<Double> stack, List<List<Double>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public List<List<Double>> combinationSum2(double[] candidates, double target) {
        int len = candidates.length;
        List<List<Double>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        double[] temp = new double[30];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            temp[i] = random.nextInt(100000);
            list.add((double) random.nextInt(100000));
        }
        System.out.println(list.size());
        Double sum = list.stream().reduce(Double::sum).get();
        System.out.println(sum);
        long start = System.nanoTime();
        List<List<Double>> lists = new LC40().combinationSum2(temp, sum);
//        Arrays.asList(10.0,1.0,2.0,7.0,6.0,1.0,5.0);
        long end = System.nanoTime();
//        for (List<Double> doubles : lists) {
//            System.out.println(doubles);
//            System.out.println(doubles.stream().reduce(Double::sum));
//        }
        System.out.println((end - start) / 1e9 + "s");
        System.out.println(lists.size());
    }

}
