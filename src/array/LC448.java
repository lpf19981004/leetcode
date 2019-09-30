package array;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/9/24
 */
public class LC448 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> numbers = findDisappearedNumbers(nums);
        System.out.println(numbers);
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int min = -1;
        if (n == 0) return list;
        if (n == 1) return Collections.singletonList(1);
        int[] temp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >0)
                temp[num -1] = min;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]!=-1){
                list.add(i+1);
            }
        }
        return list;
    }
}
