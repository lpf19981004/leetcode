package recursive;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC70 {

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
    }


    public static int climbStairs(int n) {
        if (n <= 2)
            return n;
        int one = 1;
        int two = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = two + one;
            one = two;
            two = res;
        }
        return res;
    }
}
