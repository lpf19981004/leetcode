package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class LC417 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new LC417().pacificAtlantic(
                new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (dfs(matrix, i, j)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};

    private boolean dfs(int[][] matrix, int x, int y) {
        return dfs(matrix, x, y, true) && dfs(matrix, x, y, false);
    }
    private boolean dfs(int[][] matrix, int x, int y,boolean direction) {
        if (direction && (x == 0 || y == 0)) return true;
        if (!direction && (y == matrix[x].length-1 || x == matrix.length-1)) return true;
        for (int i = 0; i < 4; i++) {
            int row = x + this.row[i];
            int col = y + this.col[i];
            if (row>=0 && row<=matrix.length - 1 && col>=0 && col<=matrix[x].length - 1 && matrix[row][col]>=matrix[x][y]){
                if (dfs(matrix, row, col, direction)) {
                    return true;
                }
            }
        }
        return false;
    }


}
