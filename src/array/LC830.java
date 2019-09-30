package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC830 {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(largeGroupPositions(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        int length = s.length();
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) return result;
        char pre = s.charAt(0);
        int cnt = 1, start = 0;
        for (int i = 1; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == pre) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    result.add(Arrays.asList(start,start+cnt-1));
                }
                pre = ch;
                start = i;
                cnt = 1;
            }
        }
        if (cnt>=3){
            result.add(Arrays.asList(start,start+cnt-1));
        }
        return result;
    }
}
