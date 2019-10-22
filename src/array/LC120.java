package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/14
 */
public class LC120 {

    public static void main(String[] args) {
        LC120 demo = new LC120();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        int res = demo.minimumTotal(list);
        System.out.println(res);
    }



    public int minimumTotal(List<List<Integer>> triangle) {
        // 自底向上动态规划
        int row = triangle.size();
        int[] dp = new int[row];
        for (int i = 0; i < row; i++)
            dp[i] = triangle.get(row - 1).get(i);
        for (int i = row - 2; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }

        return dp[0];
    }
}
