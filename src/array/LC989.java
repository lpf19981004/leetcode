package array;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/8
 */
public class LC989 {
    public static void main(String[] args) {

    }

    /**
     * 我们可以对以上的想法做一个小变化，让它实现起来更容易 —— 我们将整个加数加入数组表示的数的最低位。
     *
     * 继续之前的例子 123+912123+912，我们把它表示成 [1, 2, 3+912][1,2,3+912]。
     * 然后，我们计算 3+912 = 9153+912=915。55 留在当前这一位，将 910/10=91910/10=91 以进位的形式加入下一位。
     *
     * 然后，我们再重复这个过程，计算 [1, 2+91, 5][1,2+91,5]。
     * 我们得到 9393，33 留在当前位，将 90/10=990/10=9 以进位的形式加入下一位。继而又得到 [1+9, 3, 5][1+9,3,5]，
     * 重复这个过程之后，最终得到结果 [1, 0, 3, 5][1,0,3,5]。
     */

    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList<>();
        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
