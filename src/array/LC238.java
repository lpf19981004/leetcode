package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC238 {

    public static void main(String[] args) {
        LC238 demo = new LC238();
        int[] ints = demo.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }

}
