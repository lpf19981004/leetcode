package dfs;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC52 {

    public static void main(String[] args) {
        int ans = new LC52().totalNQueens(8);
        System.out.println(ans);
    }


    private int ans = 0;    // 保存最后的结果
    private boolean[] col;  // 记录列有没有被放置皇后
    private boolean[] left; // 记录主对角线有没有冲突
    private boolean[] right;// 记录次对角线有没有冲突
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        col = new boolean[n];
        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];
        dfs(n, 0);
        return ans;
    }
    private void dfs(int n, int k) {
        if (k == n) ans++;
        for (int i = 0; i < n; i++) {
            if (col[i] || left[i+k] || right[k-i+n-1]) continue;
            col[i] = true;
            left[i+k] = true;
            right[k-i+n-1] = true;
            dfs(n, k+1);
            col[i] = false;
            left[i+k] = false;
            right[k-i+n-1] = false;
        }
    }
}
