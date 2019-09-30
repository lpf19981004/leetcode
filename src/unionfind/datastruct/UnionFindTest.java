package unionfind.datastruct;

import java.util.Random;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class UnionFindTest {
    private static double testUnionFind(UnionFind unionFind, int m) {
        Random random = new Random();
        int size = unionFind.getSize();
        long start = System.nanoTime();
        for (long i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFind.union(p, q);
        }
        for (int i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFind.isConnected(p, q);
        }
        long end = System.nanoTime();
        return (double) (end-start)/ 1e9;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
//        UnionFind unionFind1 = new UnionFindImpl1(size);
//        System.out.println("unionFind1: " + testUnionFind(unionFind1, m));
//        UnionFind unionFind2 = new UnionFindImpl2(size);
//        System.out.println("unionFind2: " + testUnionFind(unionFind2, m));
        UnionFindImpl3 unionFind3 = new UnionFindImpl3(size);
        double u3 = testUnionFind(unionFind3, m);
        System.out.println("unionFind3: " + u3);

        UnionFindImpl4 unionFind4 = new UnionFindImpl4(size);
        double u4 = testUnionFind(unionFind4, m);
        System.out.println("unionFind4: " + u4);

        UnionFindImpl5 unionFind5 = new UnionFindImpl5(size);
        double u5 = testUnionFind(unionFind5, m);
        System.out.println("unionFind5: " + u5);
    }

}
