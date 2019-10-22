package array;

import java.util.*;

/**
 * @author liangpf
 * @date 2019/10/12
 */
public class LC56 {

    public static void main(String[] args) {
        int[][] temp = new int[][]{{1, 4}, {0,2}, {3, 5}, {6, 18}, {18, 23}};
        System.out.println(Arrays.deepToString(merge2(temp)));
    }

    public static int[][] merge(int[][] intervals) {
        List<Node> nodes = new ArrayList<>();
        for (int[] temp : intervals)
            nodes.add(new Node(temp[0], temp[1]));
        nodes.sort((Comparator.comparingInt(o -> o.left)));
        // {1, 3}, {2, 6}, {8, 10}, {15, 18}, {18, 23}
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            int left = node.left, right = node.right;
            for (int k = left; k <= right; k++) {
                if (++i < nodes.size()) {
                    Node temp = nodes.get(i);
                    if (temp.left <= right)
                        right = Math.max(right, temp.right);
                    else {
                        break;
                    }
                }
            }
            i--;
            list.add(new Node(left, right));
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            ans[i] = new int[]{node.left, node.right};
        }
        return ans;
    }

    static class Node {
        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;
    }


    public static int[][] merge2(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);

        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]大于0就交换顺序
        // 根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // i不能到最后一行,所以要小于(数组的长度 - 1)
            // 判断所在行的right和下一行的left大小,对right重新进行赋最大值,之后再不断进行while循环判断
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[] { left, right });
            i++;
        }
        return res.toArray(new int[0][]);
    }


}
