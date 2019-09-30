package unionfind.leetcode;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class LC547 {

    public static void main(String[] args) {
        LC547 demo = new LC547();
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int num = demo.findCircleNum(M);
        System.out.println(num);
    }

    private int[] parent;
    private int[] rank;

    public int findCircleNum(int[][] M) {
        int length = M.length;
        parent = new int[length];
        rank = new int[length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (M[i][j] == 1)
                    union(i, j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (parent[i] == i)
                cnt++;
        }
        return cnt;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[qRoot] += 1;
        }

    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

}
