package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangpf
 * @Date 2019/10/8
 */
public class LC1002 {

    public static void main(String[] args) {
        String[] strings = new String[]{"aaaa","aaaaa","aaaaaa"};
        List<String> list = commonChars(strings);
        System.out.println(list);
    }

    public static List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<String>();
        int[] gCount = new int[26];
        for (int i = 0; i < A.length; i++) {
            char[] ca = A[i].toCharArray();
            int[] cCount = new int[26];
            for(int j = 0; j < ca.length; j++) {
                cCount[ca[j]-'a']++;
            };
            for(int j = 0; j < 26; j++) {
                if(i == 0) {
                    gCount[j] = cCount[j];
                } else {
                    if(cCount[j] < gCount[j]) gCount[j] = cCount[j];
                };
            };
        };
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < gCount[i]; j++) ans.add(String.valueOf((char)(i+'a')));
        };
        return ans;

    };
}
