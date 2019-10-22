package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC216 {
    public static void main(String[] args) {
        LC216 demo = new LC216();
        List<List<Integer>> lists = demo.combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new ArrayList<>());
        return ans;
    }
    private void dfs(int k, int n, int cur, List<Integer> temp) {
        if (temp.size() == k && n == 0) {
            ans.add(new ArrayList<>(temp));
        } else if (temp.size() > k || n < 0) {
            return;
        }
        for (int i = cur; i <= 9; i++) {
            temp.add(i);
            dfs(k, n - i, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
