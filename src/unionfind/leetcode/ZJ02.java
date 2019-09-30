package unionfind.leetcode;

import java.util.Scanner;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class ZJ02 {
    public static void main(String[] args) {
        ZJ02 demo = new ZJ02();
        int hot = demo.getHot();
        System.out.println(hot);
    }

    public int getHot() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i]==i)
                cnt++;
        }
        scanner.close();
        return cnt;
    }

    private int[] parent;
    private int[] size;

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (size[pRoot] < size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
