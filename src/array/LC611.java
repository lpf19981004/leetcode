package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/17
 */
public class LC611 {

    public static void main(String[] args) {
        int ans = new LC611().triangleNumber(new int[]{2,2,3,4});
        System.out.println(ans);
    }


    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        return dfs(nums, 0, new ArrayList<>());
    }
    private int dfs(int[] nums, int index, List<Integer> temp) {
        int res = 0;
        if (temp.size() == 3) {
            // 满足两边之和大于第三边，两边之差小于第三边
            return (temp.get(0) + temp.get(1)) > temp.get(2) ? 1:0;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            int dfs = dfs(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
            if (temp.size() == 2 && dfs == 0){
                break;
            }
            res += dfs;
        }
        return res;
    }
}
