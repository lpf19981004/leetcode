package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/14
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 1,1,2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class LC80 {
    public static void main(String[] args) {

        LC80 a = new LC80();
        int[] nums = {1, 2, 2, 3, 3, 5, 5, 5};
        int res = a.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);

    }


    public int removeDuplicates(int[] nums) {
        int i = 0;
        // 因为值允许重复2次
        for (int n : nums){
            if (i < 2 || n != nums[i-2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }


}
