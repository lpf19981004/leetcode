package array;

/**
 * @author liangpf
 * @Date 2019/9/25
 */
public class LC665 {


    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1};
        boolean b = checkPossibility(nums);
        System.out.println(b);
    }

    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;
        int cnt = 0;
        boolean flag = false;
        if(nums[0]>nums[1]){
            flag = true;
            nums[0] = nums[1];
            cnt++;
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i-1] < nums[i+1]) {
                nums[i] = nums[i+1];
                cnt++;
                flag = true;
            }
        }
        return !flag || cnt==1;
    }
}
