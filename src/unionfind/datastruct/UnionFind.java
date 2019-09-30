package unionfind.datastruct;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public interface UnionFind {
    int getSize();

    void union(int p, int q);

    int find(int p);

    boolean isConnected(int p, int q);
}
