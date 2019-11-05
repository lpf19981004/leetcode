package dp;

/**
 * @author liangpf
 * @Date 2019/10/28
 */
public class LC303 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }


    static class NumArray {
        private int[] arr;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) return;
            int length = nums.length;
            arr = new int[length];
            arr[0] = nums[0];
            for (int i = 1; i < length; i++) {
                arr[i] = arr[i-1]+nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (arr == null || arr.length == 0) return 0;
            if (i == 0){
                return arr[j-i];
            }else {
                return arr[j] - arr[i-1];
            }
        }
    }


}
