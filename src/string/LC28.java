package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class LC28 {

    /**
     * "mississippi"
     * "issip"
     *
     * @param args
     */

    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issip";
        System.out.println(strStr(a, b));
    }


    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char first = needle.charAt(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < haystack.length(); i++) {
            char ch = haystack.charAt(i);
            if (ch == first){
                list.add(i);
            }
        }
        int index = 0;
        char ch = needle.charAt(index);
        if (list.size() == 0) return -1;
        for (Integer item : list) {
            while (item < haystack.length() && ++index < needle.length() && ch == haystack.charAt(item)) {
                ch = needle.charAt(index);
                item++;
            }
            if (index == needle.length() && ch == haystack.charAt(item)) {
                return item - index + 1;
            }
            index = 0;
            ch = needle.charAt(index);
        }
        return -1;
    }
}
