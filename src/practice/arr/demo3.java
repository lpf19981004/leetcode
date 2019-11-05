package practice.arr;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/10/31
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class demo3 {

    public static void main(String[] args) {
        int[] one = new demo3().plusOne(new int[]{1,0,9});
        System.out.println(Arrays.toString(one));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int index = len -1;
        digits[index]+=1;
        while (digits[index] == 10){
            digits[index] = 0;
            if (index-1>=0){
                digits[--index]+=1;
            }else {
                int[] temp = new int[len +1];
                temp[0] = 1;
                System.arraycopy(digits, 0, temp, 1, digits.length);
                return temp;
            }
        }
        return digits;
    }
}
