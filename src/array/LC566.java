package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/24
 */
public class LC566 {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1, 2}, {3, 4}};
//        int[][] res = matrixReshape(nums, 2, 4);
//        System.out.println(Arrays.deepToString(res));
        int[] temp = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(temp));
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) return null;
        int size = nums[0].length * nums.length;
        if (size < r * c) return nums;
        int[][] res = new int[r][c];
        int[] temp = new int[size];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                temp[index++] = nums[i][j];
            }
        }
        index = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = temp[index++];
            }
        }
        return res;
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(nums);
        int cntStart = 0, cntEnd = 0, start = 0, end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp[i]) {
                cntStart++;
            } else {
                break;
            }
        }
        if (cntStart == nums.length) {
            return 0;
        }
        for (int i = nums.length - 1; i > start; i--) {
            if (nums[i] == temp[i]){
                cntEnd++;
            }else {
                break;
            }
        }
        return nums.length - (cntStart + cntEnd);
    }
}
