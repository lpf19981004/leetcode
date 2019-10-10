package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/10/9
 */
public class LC1089 {
    public static void main(String[] args) {
        int[] arr = new int[]{0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        // 1,0,2,3,0,4,5,0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int index = arr.length - 1;
                while (index > i) {
                    arr[index] = arr[index-1];
                    index--;
                }
                i++;
            }
        }
    }
}
