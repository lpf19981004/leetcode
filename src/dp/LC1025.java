package dp;

/**
 * @author liangpf
 * @Date 2019/10/28
 */
public class LC1025 {


    public boolean divisorGame(int N) {

        return false;
    }

    private int helper(int n) {
        if (n < 1) return -1;

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                return i;
        }

        return -1;
    }
}
