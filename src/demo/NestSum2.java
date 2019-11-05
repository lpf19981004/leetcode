package demo;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/25
 */
public class NestSum2 {


    public static void main(String[] args) {
        long a = System.nanoTime();
        List<List<Double>> lists = new NestSum2().search(40, 2, Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 21.0
                , 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0));
        long b = System.nanoTime();
        System.out.println(lists.size());
        Set<String> set = new HashSet<>();
        for (List<Double> list : lists) {
            String str = list.toString();
            set.add(str);
            System.out.println(str);
        }
        System.out.println("set.size() = " + set.size());
        System.out.println((b - a) / 1e9 + "s");
    }


    private List<List<Double>> search(double target, int count, List<Double> data) {
        List<List<Double>> result = new ArrayList<>();
        int len = data.size();
        int bit = 1 << len;
        for (int i = 0; i < bit; i++) {
            if (getCnt(i) == count) {
                int s = 0;
                List<Double> temp = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    if ((i & 1 << j) != 0) {
                        s += data.get(j);
                        temp.add(data.get(j));
                    }
                }
                if (s == target) {
                    result.add(temp);
                    return result;
                } else if (Math.abs(s - target) < 0.02) {
                    result.add(temp);
                }
            }
        }


        return result;
    }

    private int getCnt(int num) {
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}
