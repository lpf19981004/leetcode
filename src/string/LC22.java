package string;

import java.util.*;

/**
 * @author liangpf
 * @date 2019/10/9
 */
public class LC22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        if (n == 1) {
            return new ArrayList<>(set);
        }
        for (int i = 2; i <= n; i++) {
            Set<String> temp = new LinkedHashSet<>();
            for (String item : set) {
                temp.add("()" + item);
                temp.add("(" + item + ")");
                temp.add(item + "()");
            }
            set = temp;
        }
        ArrayList<String> ans = new ArrayList<>(set);
        Collections.reverse(ans);
        return ans;
    }


}
