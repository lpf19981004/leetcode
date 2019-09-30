package array;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC832 {

    public static void main(String[] args) {

    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] arr = A[i];
            reverseArr(arr);
        }
        return A;
    }
    private static void reverseArr(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }
}
