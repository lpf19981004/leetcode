package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liangpf
 * @Date 2019/9/29
 */
public class demo2 {
    public static void main(String[] args) {
        List<Double> keys = new ArrayList<>();
        keys.add(2142891.50);
        keys.add(1547877.56);
        keys.add(595013.94);
        keys.add(74304.58);
        System.err.println(getNum(keys, 2217196.08));
    }


    static Set<Double> getNum(List<Double> keys, double kill) {
        int n = keys.size();
        int nbit = 1 << n;
        double in;
        Set<Double> totalSet = new HashSet<>();
        for (int i = 0; i < nbit; i++) {
            in = 0;
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j; // 由0到n右移位
                if ((tmp & i) != 0) { // 与运算，同为1时才会是1
                    System.out.print(keys.get(j) + " + ");
                    in += keys.get(j);
                }
            }
//            System.out.println(in);
            System.out.println("-----" + in);
            if (in == kill){
                totalSet.clear();
                totalSet.add(in);
                return totalSet;
            }

            totalSet.add(in);
//            if (in == kill)
//                return list;
        }
        return totalSet;
    }
}
