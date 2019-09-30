package unionfind.datastruct;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class UnionFindImpl1 implements UnionFind {

    /**
     * 使用一个数组模拟并查集
     * 一开始所有的数字都指向对应的下标各自为营
     * 通过union操作将两个元素对应下标的值修改为同一个则两者合并
     */
    private int size; // 元素个数
    private int[] id;

    @Override
    public int getSize() {
        return this.size;
    }

    public UnionFindImpl1(int size) {
        this.size = size;
        this.id = new int[size];
        for (int i : id) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == p)
                id[i] = q;
        }
    }

    @Override
    public int find(int p) {
        if (p < 0 || p > id.length)
            throw new IllegalArgumentException("下标不合法");
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
