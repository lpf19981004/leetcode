package esay;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC908 {


    public int smallestRangeI(int[] A, int K) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int target = sum / A.length;
        for (int i = 0; i < A.length; i++) {
            int temp = target - A[i];
            if (temp >= -K && temp <= K) {
                A[i] = target;
            }

        }
        return 0;
    }
}
