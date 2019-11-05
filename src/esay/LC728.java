package esay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC728 {

    public static void main(String[] args) {
        List<Integer> integers = new LC728().selfDividingNumbers(1, 22);
        System.out.println(integers);
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers( i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividingNumbers(int n) {
        int x = n;
        while (x > 0) {
            // 个位数
            int d = x % 10;
            x /= 10;
            if (d == 0 || n % d != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSelfDividingNumbers(String s, int num) {
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            int fm = ch - '0';
            if (fm == 0 || num % fm != 0)
                return false;
        }
        return true;
    }
}
