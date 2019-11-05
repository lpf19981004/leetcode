package nowcoder.shenxinfu2019;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class demo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                builder.append(scanner.next());
            }
            String key = builder.toString();
            List<Integer> val = map.get(key);
            if (val == null) {
                val = new ArrayList<>();
            }
            val.add(i);
            map.put(key, val);
            builder.setLength(0);
        }
        boolean flag = false;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() == 1) continue;
            flag =true;
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
        if (!flag){
            System.out.println("no");
        }
    }
}
