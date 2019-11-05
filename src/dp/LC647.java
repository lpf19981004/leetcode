package dp;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC647 {
        /*
            给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
            具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

            示例 1:
            输入: "abc"
            输出: 3
            解释: 三个回文子串: "a", "b", "c".
            使用中心扩展法,如果扩展的两个指针指向的字符相等则是一个回文串
         */

    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 处理奇偶长度的情况
            ans += expand(s, i, i);
            ans += expand(s, i, i + 1);
        }
        return ans;
    }


    private int expand(String s, int start, int end) {
        int count = 0;
        // 从中心向两边扩展 遇到不相等的则直接退出
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }
}
