package unionfind.leetcode;

import java.util.Scanner;

/**
 * @author liangpf
 * @Date 2019/9/20
 * 字节跳动大闯关
 */
public class ZJ01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        UF uf = new UF(n + 1);
        for (int i = 1; i <= n; i++) {
            int input = scanner.nextInt();
            while (input != 0) {
                uf.union(i, input);
                input = scanner.nextInt();
            }
        }
        System.out.println(uf.getGroupCount());
        scanner.close();
    }

    private static class UF {
        int[] parent;
        int[] rank;

        UF(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
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

        public int find(int p) {
            if (p < 0 || p > parent.length)
                throw new IllegalArgumentException("this index is not support : " + p);
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int getGroupCount() {
            int cnt = 0;
            for (int i = 1; i < parent.length; i++) {
                if (parent[i] == i)
                    cnt++;
            }
            return cnt;
        }

    }
}
