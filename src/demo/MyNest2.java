package demo;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/26
 */
public class MyNest2 {

    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            list.add((double) random.nextInt(100000));
        }
        System.out.println(list.size());
        Double sum = list.stream().reduce(Double::sum).get();
//        System.out.println(sum);
        List<Double> data = Arrays.asList(11.19, -129.20, 2456.13, 215.24, 132.24);
        long start = System.nanoTime();
        List<List<Double>> lists = new MyNest2()
                .getNestSum(new ArrayList<>(data), 2685.59);
//        Arrays.asList(10.0,1.0,2.0,7.0,6.0,1.0,5.0);
        long end = System.nanoTime();
        System.out.println(data.stream().reduce(Double::sum));
        Map<Double,List<Double>> map = new TreeMap<>();
        for (List<Double> doubles : lists) {
            Double result = doubles.stream().reduce(Double::sum).get();
            map.put(result, doubles);
        }
        for (Map.Entry<Double, List<Double>> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println((end - start) / 1e6 + " ms");
        System.out.println(lists.size());
    }

    /**
     * 获取误差为百分之10范围内的所有组合
     *
     * @param data   数据
     * @param target 目标值
     * @return 所有组合
     */
    private List<List<Double>> getNestSum(List<Double> data, double target) {
        if (data.size() == 0) return new ArrayList<>();
        Collections.sort(data);
        return sol(data, 0, target);
    }

    private List<List<Double>> sol(List<Double> data, int start, double target) {
        List<List<Double>> res = new ArrayList<>();
        for (int i = start; i < data.size(); ++i) {
            // 避免重复计算
            if (i > start && data.get(i).equals(data.get(i - 1))) continue;
            if (Math.abs(data.get(i) - target) < (target * 0.1)) {
                List<Double> temp = new LinkedList<>();
                temp.add(data.get(i));
                res.add(temp);
                break;
            } else if (data.get(i) > target) break;
            else {
                List<List<Double>> r = sol(data, i + 1, target - data.get(i));
                if (data.size()>0) {
                    for (List<Double> item : r) {
                        item.add(0, data.get(i));
                        res.add(item);
                    }
                }
            }
        }
        return res;
    }
}
