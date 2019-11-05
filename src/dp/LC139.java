package dp;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/30
 */
public class LC139 {

    public static void main(String[] args) {
        LC139 demo = new LC139();
        boolean res = demo.wordBreak("leetcode", Arrays.asList("leete", "code"));
        System.out.println(res);
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char key = s.charAt(i);
            Integer cnt = map.get(key);
            if (cnt == null) {
                cnt = 1;
            } else {
                cnt += 1;
            }
            map.put(key, cnt);
        }
        for (String str : wordDict) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                Integer cnt = map.get(c);
                if (cnt == null || cnt == 0) {
                    return false;
                }
                map.put(c, cnt - 1);
            }
        }
        return true;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        return dfs(s, new HashSet<>(),0,new Boolean[s.length()]);
    }

    public boolean dfs(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && dfs(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }
}
