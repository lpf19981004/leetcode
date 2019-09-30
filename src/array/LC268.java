package array;

/**
 * @author liangpf
 * @Date 2019/9/24
 */
public class LC268 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length + 1;
        int sum = (n * (n - 1)) / 2;
        for(int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
