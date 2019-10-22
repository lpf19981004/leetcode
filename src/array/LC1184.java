package array;

import java.util.*;

/**
 * @author liangpf
 * @date 2019/10/11
 */
public class LC1184 {
    public static void main(String[] args) {

    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        Map<Integer, List<Map<Integer,Integer>>> map = new HashMap<>();
        int n = distance.length;
        for (int i = 0; i < n; i++) {
            // 下一个公交站
            int val = (i + 1) % n;
            // 距离
            int dis = distance[i];
            List<Map<Integer, Integer>> mapList = map.get(i);
            if (mapList == null){
                mapList = new ArrayList<>();
            }
            mapList.add(Collections.singletonMap(val, dis));

            List<Map<Integer, Integer>> maps = map.get(val);
            if (maps == null){
                maps = new ArrayList<>();
            }
            maps.add(Collections.singletonMap(i, dis));
        }

        return 0;
    }
}
