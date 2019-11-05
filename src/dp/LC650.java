package dp;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC650 {

    public int minSteps(int n) {
        /*
            用dp[i]表示打印i个字符需要的最少次数
            dp[0] = 0;
            dp[1] = 2;
            剪切板一开始为空,第一次必须为复制
            每次操作可以沿用上一个剪切板的内容，也可以粘贴剪切板中的内容
            dp[i] = Math.min()
         */
        return dfs(n,0,1)+1;
    }

    private int dfs(int n, int k, int c) {

        int ans = 0;
        ans = Math.min(dfs(n, k+1, c), dfs(n, k+1, c+c));
        return ans;
    }
}
