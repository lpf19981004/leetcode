package trie;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class LC720 {

    public static void main(String[] args) {
        String[] str = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(str));
    }

    public static String longestWord(String[] words) {
        if (words.length == 0) return "";
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length()!=o2.length()){
                return o1.length()>o2.length()?1:-1;
            } else {
                return o1.compareTo(o2);
            }
        });
        return words[words.length-1];
    }
}
