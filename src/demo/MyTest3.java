package demo;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/26
 */
public class MyTest3 {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Random random = new Random();
        int[] a = new int[30];
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            int e = random.nextInt(100000);
            list.add((double) e);
            a[i] = e;
            sum += e;
        }
        System.out.println(sum);
        long start = System.nanoTime();
        double res = new MyTest3().getSum(Arrays.asList(20.0,15.0,5.0,20.0,12.0,8.0,0.3,0.3), 40.3);
        long end = System.nanoTime();
        System.out.println((end - start) / 1e6 + " ms");
        System.out.println(res);
    }

    /**
     * 通过消除法进行合计计算
     *
     * @param data   数据
     * @param target 目标值
     * @return 近似值
     */
    private double getSum(List<Double> data, double target) {

        int top = 0, down = 1;
        double sum = 0;
        while (top < data.size() && Math.abs(sum - target) > 0.02) {
            Double topVal = data.get(top);
            if (down < data.size() - 1 && topVal.equals(data.get(down))) {
                sum += topVal;top++;down++;
                continue;
            } else if (down == data.size() - 1 && topVal.equals(data.get(down))) {
                if (Math.abs(sum + topVal - target) < 0.02) {
                    sum+=topVal;
                    break;
                }
                else sum += 2 * topVal;
            }
            // 存储子集合
            double temp = 0;
            while (temp < topVal) {
                temp += data.get(down++);
            }
            if (temp == topVal) {
                top = down++;
                sum += topVal;
            } else {
                top++;
                down = top + 1;
            }
        }
        return sum;
    }


}
