package array;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC914 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3,3};
        boolean b = hasGroupsSizeX(nums);
        System.out.println(b);

    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : deck) {
            map.merge(value, 1, Integer::sum);
        }
        int minDivisor = getMinDivisor(new ArrayList<>(map.values()));
        return minDivisor >= 2;
    }

    private static int getMinDivisor(List<Integer> list) {
        if (list == null || list.size() == 0) return 0;
        list.sort(Integer::compareTo);
        Iterator<Integer> iterator = list.iterator();
        // 第一个元素
        Integer min = iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % min != 0) {
                return 0;
            }
        }
        return min;
    }
}
