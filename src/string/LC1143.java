package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangpf
 * @date 2019/10/12
 */
public class LC1143 {

    public static void main(String[] args) {
        LC1143 demo = new LC1143();
        int ans = demo.longestCommonSubsequence("abcde", "ace");
        System.out.println(ans);

    }


    public int longestCommonSubsequence(String text1, String text2) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int index = 0;
        if (text1.length() < text2.length()) {
            while (text1.length() < text2.length()) {
                ans = getAns(text2, text1, ans, set);
                max = Math.max(ans, max);
                text1 = text1.substring(++index);
            }
        } else {
            while (text1.length() > text2.length()) {
                ans = getAns(text1, text2, ans, set);
                max = Math.max(ans, max);
                text1 = text1.substring(++index);
            }
        }
        return ans;
    }

    private int getAns(String text1, String text2, int ans, Set<Character> set) {
        for (int i = 0; i < text2.length(); i++) {
            set.add(text2.charAt(i));
        }
        int index = 0;
        while (index < text1.length() && set.size() > 0) {
            char ch = text1.charAt(index++);
            if (set.remove(ch)) {
                ans++;
            }
        }
        return ans;
    }
}
