package demo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/29
 */
public class NestSumTest {

    private static final int TOTAL = 500;

    private static List<Double> timeList;

    private static int time = 0;

    public static void main(String[] args) {
        OperatingSystemMXBean osMXBean = ManagementFactory
                .getOperatingSystemMXBean();
        com.sun.management.OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) osMXBean;
        long cpuTime = bean.getProcessCpuTime();
        timeList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            time = 0;
            testMethodSpeed();
        }
        long end = bean.getProcessCpuTime();
        System.out.println(end-cpuTime);
//        RuntimeMXBean.getUptime()-RuntimeMXBean.getUptime()
        System.out.println(timeList.stream().reduce(Double::sum));
    }

    private static void testMethodSpeed() {
        // 产生测试数据,无重复随机数
        Random random = new Random();
        double target = 0;
        Set<Double> set = new LinkedHashSet<>();
        while (set.size() < TOTAL) {
            double v = random.nextDouble() * 1000;
            if (set.add(v)) {
                target += v;
            }
        }
//        System.out.println(target);
        List<Double> data = new ArrayList<>(set);
        // 产生数据完毕,测试数量为TOTAL
        long start = System.nanoTime();
        getNestSum(data, target);
        long end = System.nanoTime();
        double v = (end - start) / 1e6;
//        System.out.println(v + "ms");
//        System.out.println("运算次数 : " + time + " 次");
        timeList.add(v);
    }


    // --------------------------方案一------------------------------------

    private static boolean exit = false;

    /**
     * 获取误差为百分之10范围内的所有组合
     *
     * @param data   数据
     * @param target 目标值
     * @return 所有组合
     */
    private static List<List<Double>> getNestSum(List<Double> data, double target) {
        if (data.size() == 0) return new ArrayList<>();
        exit = false;
        Collections.sort(data);
        return sol(data, 0, target);
    }


    private static List<List<Double>> sol(List<Double> data, int start, double target) {
        List<List<Double>> res = new ArrayList<>();
        if (exit) return res;
        time+=1;
        for (int i = start; i < data.size(); ++i) {
            // 避免重复计算
            if (i > start && data.get(i).equals(data.get(i - 1))) continue;
            if (Math.abs(data.get(i) - target) < 0.02) {
                List<Double> temp = new ArrayList<>();
                temp.add(data.get(i));
                res.add(temp);
                exit = true;
                break;
            } else if (Math.abs(data.get(i) - target) < (target * 0.1)) {
                List<Double> temp = new ArrayList<>();
                temp.add(data.get(i));
                res.add(temp);
                break;
            } else if (data.get(i) > target) {
                break;
            } else {
                List<List<Double>> r = sol(data, i + 1, target - data.get(i));
                for (List<Double> item : r) {
                    item.add(0, data.get(i));
                    res.add(item);
                }
            }
        }
        return res;
    }
    // --------------------------方案一------------------------------------


    // --------------------------方案二------------------------------------

    /**
     * @param data
     * @param m
     * @return
     */
    private static double nestSum(List<Double> data, double m) {
        int size = data.size();
        int[] value = new int[size];
        for (int i = 0; i < size; i++) value[i] = (int) (data.get(i) * 100);
        double v = nestSum(m, value);
        if (Math.abs(v - m) < 0.02)
            return v;
        else
            return nestSum(m + 0.02, value);
    }

    private static double nestSum(double m, int[] value) {
        int n = (int) (m * 100);
        int[] result = new int[n + 1];
        for (int i = 1; i <= value.length; i++)
            for (int j = n; j >= 1; j--)
                if (j >= value[i - 1]) {
                    result[j] = Math.max(result[j], result[(j - value[i - 1])] + value[i - 1]);
//                    System.out.println(result[j]);
                    if (Math.abs(result[j] - n) < 2) {
                        return m;
                    }
                }
        return (double) result[n] / 100;
    }

    // --------------------------方案二------------------------------------


}
