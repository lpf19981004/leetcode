package demo;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/26
 */
public class MyNest1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int[] a = new int[30];
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            int e = random.nextInt(10000000);
            a[i] = e;
            list.add(e);
            sum+=e;
        }
        System.out.println(sum);
        long start = System.nanoTime();
        List<List<Integer>> lists = new MyNest1().combinationSum2(list, sum);
        long end = System.nanoTime();
        System.out.println((end - start) / 1e9 + "s");
        System.out.println(lists.size());
    }


    private List<List<Integer>> ret = new ArrayList<>();
    private Map<String,Integer> m = new HashMap<>();

    void solve(List<Integer> cand, int t) {
        List<Integer> q = new ArrayList<>();
        int i = 0;
        if (cand.size() == 0) return;
        q.add(0);
        while (!q.isEmpty()) {
            int idx = q.get(q.size()-1);
            t -= cand.get(idx);
            if (Math.abs(t)<0.02) {
                addEntry(cand, q);
                q.remove(q.size()-1);
                t += cand.get(idx);
                if (q.size()!=0) {
                    idx = q.get(q.size()-1);
                    q.remove(q.size()-1);
                    t += cand.get(idx);
                    if (idx + 1 < cand.size())
                        q.add(idx + 1);
                }
                continue;
            }

            if (idx + 1 == cand.size() || t < 0) {
                t += cand.get(idx);
                q.remove(q.size()-1);
                if (!q.isEmpty()) {
                    idx = q.get(q.size()-1);
                    q.remove(q.size()-1);
                    t += cand.get(idx);
                    q.add(idx + 1);
                }
                continue;
            }
            q.add(idx + 1);
        }
    }

    void addEntry(List<Integer> cand,List<Integer> q) {
        List<Integer> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i : q) {
            res.add(cand.get(i));
            s.append(cand.get(i)).append("|");
        }
        if (m.get(s.toString()) != null) return;
        m.put(s.toString(), 1);
        ret.add(res);
    }

    List<List<Integer>> combinationSum2(List<Integer> candidates, int target) {
        Collections.sort(candidates);
        solve(candidates, target);
        return ret;
    }
}
