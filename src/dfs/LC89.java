package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC89 {
    public static void main(String[] args) {
        List<Integer> ans = new LC89().grayCode(2);
        System.out.println(ans);
    }

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            ans.add(0);
            return ans;
        }
        dfs(n, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int n, int k, List<Integer> list) {
        if (k == n && list.size() == n) {
            int sum = 0;
            int pow = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                Integer bit = list.get(i);
                sum += bit * Math.pow(2, pow++);
            }
            ans.add(sum);
            list.remove(list.size() - 1);
            return;
        }
        list.add(0);
        dfs(n, k + 1, list);
        list.add(1);
        dfs(n, k + 1, list);
        if (list.size() > 0)
            list.remove(list.size() - 1);
    }

}
