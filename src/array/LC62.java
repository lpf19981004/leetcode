package array;

/**
 * @author liangpf
 * @date 2019/10/12
 * <p>
 * 记忆型递归解法
 */
public class LC62 {

    public static void main(String[] args) {
        LC62 demo = new LC62();
        int i = demo.uniquePaths2(1, 1);
        System.out.println(i);
    }

    private int[][] temp;

    public int uniquePaths(int m, int n) {
        temp = new int[m + 1][n + 1];
        return findPath(1, 1, m, n);
    }

    private int findPath(int x, int y, int m, int n) {
        // 如果走到了终点返回1
        if (x == m && y == n) return 1;
        int res = 0;
        // 查询之前走过的路径
        if (temp[x][y] != 0) {
            return temp[x][y];
        }
        // 走到了最右端,只能往下边走
        if (x == m) {
            res += findPath(x, y + 1, m, n);
        } else if (y == n) { // 走到了最下边，只能往右边走
            res += findPath(x + 1, y, m, n);
        } else {
            // 两边的可能性
            res += findPath(x, y + 1, m, n);
            res += findPath(x + 1, y, m, n);
        }
        // 记忆走的路径
        temp[x][y] = res;
        return res;
    }

    /**
     * 动态规划解法
     */
    public int uniquePaths2(int m, int n) {
        int[][] temp = new int[m][n];
        // 处理第一行
        for (int j = 0; j < n; j++) {
            temp[0][j] = 1;
        }
        // 处理第一列
        for (int i = 0; i < m; i++) {
            temp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }
        return temp[m - 1][n - 1];
    }

}
