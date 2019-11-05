package esay;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
