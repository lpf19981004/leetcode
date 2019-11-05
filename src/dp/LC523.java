package dp;

/**
 * @author liangpf
 * @Date 2019/11/4
 */
public class LC523 {

    public static void main(String[] args) {
        boolean b = new LC523().checkSubarraySum(new int[]{0, 0}, 0);
        System.out.println(b);
    }


    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum == 0 && nums.length > 1) return true;
        if (k == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp / k == 0) return true;
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp / k == 0) return true;
            }
        }
        return false;
    }

}
