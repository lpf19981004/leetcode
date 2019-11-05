package dp;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC338 {

    public static void main(String[] args) {
        new LC338().countBits(5);
    }

    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i = 0; i <= num; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}
