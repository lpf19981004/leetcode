package practice.arr;

/**
 * @author liangpf
 * @Date 2019/10/31
 * 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * <p>
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 * <p>
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 * 说明:
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class demo1 {

    /*
        一个数组所有的数据都是无序的
        1.中心索引左边的数据之和等于中心索引右边的数据之和
        2.每一个位置的数都可能作为中心索引
        1, 7, 3, 6, 5, 6
     */

    public static void main(String[] args) {
        int ans = new demo1().pivotIndex(new int[]{-1,-1,0,1,1,0});
        System.out.println(ans);
    }

    public int pivotIndex(int[] nums) {
        if (nums.length <= 2) return -1;
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        for (int i = 0; i < len ; i++) {
            if (sum[i] - nums[i] == sum[len - 1] - sum[i]) {
                return i;
            }
        }
        return -1;
    }
}
