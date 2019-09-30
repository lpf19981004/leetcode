package unionfind.datastruct;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class UnionFindImpl5 implements UnionFind {

    private int size;// 大小
    private int[] parent;// 父节点
    private int[] rank;// 表示当前集合中的个数

    public UnionFindImpl5(int size) {
        this.size = size;
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

    }

    @Override
    public int getSize() {
        return this.size;
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
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return parent[p];
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);// 找到p的父节点
        int qRoot = find(q);// 找到Q的父节点
        if (pRoot == qRoot)
            return;
        if (rank[pRoot] < rank[qRoot]) {
            this.parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            this.parent[qRoot] = pRoot;// 将p的父节点指向q的父节点
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
