package array;

/**
 * @author liangpf
 * @date 2019/10/12
 */
public class LC42 {
    public static void main(String[] args) {

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);

    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int index = 0;
        int ans = 0;
        if (height[0] == 0){
            index++;
        }
        int len = height.length;
        while (index < len) {
            // 找到第一个柱子
            while (index < len && height[index] == 0) {
                index++;
            }
            int left = index;
            if (index >= len) {
                break;
            }
            int right = index + 1;
            // 找到第二个柱子
            while (right < len && height[right] < height[left]) {
                right++;
            }
            if (right == len && height[right - 1] < height[left]) {
                index = left + 1;
                continue;
            }
            ans += (right - left - 1) * height[left];
            for (int i = left + 1; i < right; i++) {
                ans -= height[i];
            }
            index = right;
        }
        return ans;
    }
}
