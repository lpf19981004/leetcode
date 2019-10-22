package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/12
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class LC34 {

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,8,8,10};
        int[] ints = searchRange(nums, 7);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == target){
                int temp = mid;
                int first = mid;
                int last = mid;
                while (--temp>=0 && nums[temp] == target){
                    first = temp;
                }
                temp = mid;
                while (++temp<=nums.length-1 && nums[temp] == target){
                    last = temp;
                }
                return new int[]{first,last};
            }
            if (nums[mid]>target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
