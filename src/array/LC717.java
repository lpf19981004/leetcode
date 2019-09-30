package array;

/**
 * @author liangpf
 * @Date 2019/9/29
 */
public class LC717 {

    public static void main(String[] args) {
        LC717 demo = new LC717();
        int[] nums = new int[]{1,0,0};
        boolean one = demo.isOneBitCharacter(nums);
        System.out.println(one);
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
