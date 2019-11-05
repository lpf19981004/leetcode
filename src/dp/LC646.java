package dp;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC646 {

    public static void main(String[] args) {
        int chain = new LC646().findLongestChain(new int[][]{{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}});
        System.out.println(chain);
    }


    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int len = 1;
        int curMax = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > curMax) {
                len++;
                curMax = pairs[i][1];
            }
        }
        return len;
    }
}
