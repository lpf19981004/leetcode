package array;

/**
 * @author liangpf
 * @Date 2019/9/25
 */
public class LC605 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,0,0};
        System.out.println(canPlaceFlowers(nums, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > flowerbed.length) return false;
        if (flowerbed.length == 1) return (flowerbed[0] == 0 && n == 1) || (flowerbed[0] == 1 && n == 0);
        int left = 0, right = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            left = i - 1;
            right = i + 1;
            if (i == flowerbed.length - 1) {
                if (flowerbed[left] == 0 && flowerbed[i] == 0) {
                    n--;
                    break;
                }
            }
            if (left < 0 && flowerbed[i] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (left >= 0 && flowerbed[left] == 0 && flowerbed[i] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
