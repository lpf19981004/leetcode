package demo;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/25
 */
public class NestSum {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            list.add((double) random.nextInt(30000));
        }
        System.out.println(list.size());
        Double sum = list.stream().reduce(Double::sum).get();
        System.out.println(sum);
        long start = System.nanoTime();
        double lists = new NestSum().nestSum(sum,list);
//        Arrays.asList(10.0,1.0,2.0,7.0,6.0,1.0,5.0);
        long end = System.nanoTime();
//        for (List<Double> doubles : lists) {
//            System.out.println(doubles);
//            System.out.println(doubles.stream().reduce(Double::sum));
//        }
        System.out.println((end - start) / 1e9 + "s");
        System.out.println(lists);
    }

    private double nestSum(double m, List<Double> data) {
        int size = data.size();
        int[] value = new int[size];
        for (int i = 0; i < size; i++) value[i] = (int) (data.get(i) * 100);
        double v = nestSum(m, value);
        if (Math.abs(v - m) < 0.02 || v < m) {
            return v;
        } else {
            return nestSum(m + 0.02, value);
        }
    }

//    private double nestSum(double m, long[] value) {
//        long n = (long) (m * 100);
//        HashMap<Long, Long> result = new HashMap<>(1024);
//        for (long i = 0; i <= n; i++) {
//            if (i>value[0]){
//                result.put(i, value[0]);
//            }else {
//                result.put(i, 0L);
//            }
//        }
//        for (int i = 1; i <= value.length; i++)
//            for (long j = n; j >= value[i - 1]; j--) {
//                Long temp = result.get(j);
//                long diff = j - value[i - 1];
//                temp = Math.max(temp, result.get(diff) + value[i - 1]);
//                if (temp == n)
//                    return (double) temp / 100;
//                result.put(j, temp);
//            }
//        return (double) result.getOrDefault(n, 0L) / 100;
//    }
    private double nestSum(double m, int[] value) {
        int n = (int) (m * 100);
        int[] result = new int[n + 1];
        for (int i = 1; i <= value.length; i++)
            for (int j = n; j >= 1; j--)
                if (j >= value[i - 1]) {
                    result[j] = Math.max(result[j], result[j - value[i - 1]] + value[i - 1]);
                }
        return (double) result[n] / 100;
    }
}
