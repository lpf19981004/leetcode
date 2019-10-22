package dfs;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC733 {

    public static void main(String[] args) {
        int[][] image = new LC733().floodFill(new int[][]{
                        {0, 0, 0},
                        {0, 1, 1}},
                1, 1, 2);
        for (int[] img : image) {
            System.out.println(Arrays.toString(img));
        }
    }

    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return image;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[x].length) return;
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                dfs(image, x + row[i], y + col[i], oldColor, newColor);
            }
        }
    }
}
