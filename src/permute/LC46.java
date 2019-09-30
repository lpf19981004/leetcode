package permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/9/26
 */
public class LC46 {

    public static void main(String[] args) {
        LC46 demo = new LC46();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = demo.permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }

    private  List<List<Integer>> res = new ArrayList<>();

    public  List<List<Integer>> permute(int[] nums) {
        permute(nums,0);
        return res;
    }

    private  void permute(int[] chars, int k) {
        if (k == chars.length){
            List<Integer> list = new ArrayList<>();
            for (int i : chars) {
                list.add(i);
            }
            res.add(list);
        }
        for (int i = k; i < chars.length; i++) {
            swap(chars,i,k);
            permute(chars,k+1);
            swap(chars,i,k);
        }
    }
    private  void swap(int[] chars, int i, int k) {
        int temp = chars[i];
        chars[i] = chars[k];
        chars[k] = temp;
    }
}
