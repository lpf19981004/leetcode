package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC77 {

    public static void main(String[] args) {
        List<List<Integer>> list = new LC77().combine(2, 1);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) return ans;
        if (n == 1) {
            ans.add(Collections.singletonList(1));
            return ans;
        }
        dfs(n, 1, k, new ArrayList<>());
        return ans;
    }

    private void dfs(int n, int index, int k, List<Integer> list) {
        if (list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n-(k-list.size())+1; i++) {
            list.add(i);
            dfs(n, i+1, k, list);
            list.remove(list.size()-1);
        }
    }
}
