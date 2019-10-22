package array;

import java.util.*;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC73 {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        LC73 demo = new LC73();
        demo.setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Node> list = new ArrayList<>();
        // 找到0所在的位置
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0)
                    list.add(new Node(i, j));
            }
        }
        for (Node node : list) {
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < colLen; i++) {
                matrix[x][i] = 0;
            }
            for (int i = 0; i < rowLen; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
