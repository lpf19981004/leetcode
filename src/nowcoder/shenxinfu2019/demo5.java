package nowcoder.shenxinfu2019;


import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            list.add(new Pair<>(left, right));
        }
        list.sort((p1, p2) -> {
            if (p1.getKey().equals(p2.getKey())) {
                return p2.getValue() - p1.getValue();
            }
            return p1.getKey() - p2.getKey();
        });
        ListIterator<Pair<Integer, Integer>> it = list.listIterator();
        while (it.hasNext()) {
            Pair<Integer, Integer> pair = it.next();
            Integer left = pair.getKey();
            Integer right = pair.getValue();
            while (it.hasNext()) {
                Pair<Integer, Integer> next = it.next();
                if (next.getKey() <= right) {
                    right = Math.max(next.getValue(), right);
                    it.remove();
                }
            }
            pair.setKey(left);
            pair.setValue(right);
        }
        for (Pair<Integer, Integer> pair : list) {
            System.out.println(pair.key + " " + pair.value);
        }
    }

    private static class Pair<K,V>{
        K key;
        V value;


        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
