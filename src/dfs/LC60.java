package dfs;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class LC60 {

    public static void main(String[] args) {
        String permutation = new LC60().getPermutation(3, 3);
        System.out.println(permutation);
    }

    private int cur = 0;
    private boolean exit = false;
    private String[] ans;

    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) builder.append(i);
        ans = new String[k];
        dfs(builder, 0, k);
        return ans[k-1];
    }

    private void dfs(StringBuilder n, int index, int k) {
        if (exit) return;
        if (index == n.length()) {
            ans[cur++] = n.toString();
            if (cur == k){
                exit = true;
                return;
            }
        }
        for (int i = index; i < n.length(); i++) {
            swap(n, i, index);
            dfs(n, index + 1, k);
            swap(n, i, index);
        }
    }
    private void swap(StringBuilder n, int index1, int index2) {
        char ch1 = n.charAt(index1);
        char ch2 = n.charAt(index2);
        n.setCharAt(index1, ch2);
        n.setCharAt(index2, ch1);
    }


}
