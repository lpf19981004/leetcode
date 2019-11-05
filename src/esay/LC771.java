package esay;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))){
                ans++;
            }
        }
        return ans;
    }
}
