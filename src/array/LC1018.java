package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/9
 */
public class LC1018 {
    public static void main(String[] args) {
        long res = transfer("1");
        System.out.println(res);
        List<Boolean> booleans = prefixesDivBy5(new int[]{1, 1, 1});
        System.out.println(booleans);

    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        if (A.length == 0) return ans;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            builder.append(A[i]);
            long num = transfer(builder.toString());
            ans.add(num/5==0 && num%5 == 0);
        }
        return ans;
    }

    private static long transfer(String str) {
        long num = 0;
        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            num+=Math.pow(2, j)*(str.charAt(i)-'0');
        }
        return num;
    }
}
