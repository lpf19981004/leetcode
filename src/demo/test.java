package demo;

import java.util.Arrays;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/9/29
 */
public class test {
    public static void main(String[] args) {

        String text = "02184-5415461";
        System.out.println(text.matches("^\\d.*\\d$"));
        double nearestSum = getNearestSum(40.5, new double[]{0.0,1.0, 2.0, 3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0,19.0,20.0,21.0
                ,22.0,23.0,24.0,25.0,26.0,27.0,28.0,29.0});
        System.out.println(nearestSum);

    }


    private static double getNearestSum(double m, double[] value) {
        int len = (int) (m);
        double[] result = new double[len+1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = len; j >= 1; j--) {
                if (j >= value[i-1]) {
                    result[j] = Math.max(result[j], result[(int)(j-value[i-1])] + value[i-1]);
                }
            }
        }
        return result[len];
    }


    private static List<Double> getNearestSum(int m, int end, int[] value) {
        m-=value[end];

        return null;
    }



}
