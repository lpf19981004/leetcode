package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author liangpf
 * @date 2019/10/10
 */
public class LC1128 {

    public static void main(String[] args) {
        int res = numEquivDominoPairs(new int[][]{{1, 1}, {2, 2}, {1, 1}, {1, 1},{1,2},{1,2}});
        System.out.println(res);
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            if(map.containsKey(d[0]) && map.get(d[0]) == d[1]){
                cnt++;
                map.remove(d[0]);
            }else if (d[0] == d[1]){
                cnt++;
            }else {
                map.put(d[0], d[1]);

            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            Integer temp = map.get(value);
            if (temp != null && temp.equals(key)) {
                cnt++;
                it.remove();
            }
        }
        return cnt;
    }
}
