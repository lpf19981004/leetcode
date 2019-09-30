package unionfind.datastruct;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class UnionFindImpl3 implements UnionFind {

    private int[] parent;// 父节点
    private int[] sz;// 表示当前集合中的个数

    public UnionFindImpl3(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 找到某个节点的根节点
     *
     * @param p p
     * @return p的父节点
     */
    @Override
    public int find(int p) {
        if (p < 0 || p > parent.length)
            throw new IllegalArgumentException("数组下标不合法");
        while (p != parent[p]) {
            p = parent[p];
        }
         return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);// 找到p的父节点
        int qRoot = find(q);// 找到Q的父节点
        if (pRoot == qRoot)
            return;
        if (sz[pRoot] < sz[qRoot]) {
            this.parent[pRoot] = qRoot;
            this.sz[qRoot]+=this.sz[pRoot];
        }else {
            this.parent[qRoot] = pRoot;// 将p的父节点指向q的父节点
            this.sz[pRoot]+=this.sz[qRoot];
        }
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
