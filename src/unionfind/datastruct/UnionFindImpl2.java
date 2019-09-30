package unionfind.datastruct;

/**
 * @author liangpf
 * @Date 2019/9/20
 * 同样是使用数组来存储但是数据结构是指向父节点的树结构
 */
public class UnionFindImpl2 implements UnionFind {

    private int size;// 大小
    private int[] parent;

    public UnionFindImpl2(int size) {
        this.size = size;
        this.parent = new int[size];
        for (int i : this.parent) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * 找到某个节点的根节点
     * @param p p
     * @return  p的父节点
     */
    @Override
    public int find(int p) {
        if (p<0 || p>parent.length)
            throw new IllegalArgumentException("数组下标不合法");
        while (p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int parentP = find(p);// 找到p的父节点
        int parentQ = find(q);// 找到Q的父节点
        if (parentP == parentQ) {
            return;
        }
        this.parent[parentP] = parentQ;// 将p的父节点指向q的父节点
    }



    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
