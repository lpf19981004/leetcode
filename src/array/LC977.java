package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC977 {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-3,-2,1};
        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        int index = 0;
        while (index < A.length - 1) {
            if (A[index] >= A[index + 1]) {
                int k = index;
                int temp = A[k];
                while (k < A.length - 1 && temp >= A[k + 1])
                    k++;
                int m = index;
                while (m < k) {
                    A[m] = A[m + 1];
                    m++;
                }
                A[k] = temp;
            } else {
                index++;
            }
        }
        return A;
    }
}
