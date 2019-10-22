package array;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC153 {

    public static void main(String[] args) {
        LC153 demo = new LC153();
        int min = demo.findMin(new int[]{3,4,5,-1,0,1,2});
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            // 左侧有序
            if (nums[start] <= nums[mid]) {
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                min = Math.min(nums[mid], min);
                end = mid-1;
            }else {
                start++;
            }
        }
        return min;
    }
}
