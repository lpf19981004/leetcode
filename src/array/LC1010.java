package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangpf
 * @Date 2019/10/8
 */
public class LC1010 {


    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            map.put(time[i],i);
        }
        Arrays.sort(time);
        int start = 0;
        int end = time.length - 1;
        while (start < end) {
            int sum = time[start] + time[end];
            if (sum / 60 == 0) {

            } else if (sum % 60 > 0) {

            }else if (sum%60 == 0){

            }
        }

        return 0;
    }
}
