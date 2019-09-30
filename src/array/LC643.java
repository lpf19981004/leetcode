package array;

/**
 * @author liangpf
 * @Date 2019/9/25
 */
public class LC643 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,3,3};
        double maxAverage = findMaxAverage(nums, 4);
        System.out.println(maxAverage);

    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        int max = 0, temp = 0;
        for(int i=0;i<=nums.length-k;i++){
            for (int j = i; j < k+i; j++)
                temp+=nums[j];
            max = Math.max(temp,max);
            temp = 0;
        }
        return (double)max/k;
    }
}
