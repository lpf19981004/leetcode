package array;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC495 {

    public static void main(String[] args) {
        LC495 d = new LC495();
        int poisonedDuration = d.findPoisonedDuration(new int[]{1,2}, 2);
        System.out.println(poisonedDuration);
    }


    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        // 记录第一次的中毒解除时间
        int end = duration + timeSeries[0];
        // timeSeries不为零至少中毒一次
        int ans = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] >= end) {
                ans += duration;
            } else {
                ans += timeSeries[i]+duration-end;
            }
            end = timeSeries[i]+duration;
        }
        return ans;
    }
}
