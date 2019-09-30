package demo;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/9/29
 */
public class LC17 {
    public static void main(String[] args) {
        LC17 demo = new LC17();
        List<String> list = demo.letterCombinations("234");
        System.out.println(list);
    }

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        List<List<String>> temp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            List<String> list = map.get(ch);
            temp.add(list);
        }
        dfs(temp, new StringBuilder(), 0, 0);
        return result;
    }

    private void dfs(List<List<String>> lists, StringBuilder res, int out, int in) {
        if (out == lists.size()){
            result.add(res.toString());
            res.deleteCharAt(res.length()-1);
            return;
        }
        List<String> list = lists.get(out);
        for (int i = 0; i < list.size(); i++) {
            while (res.length()>out){
                res.deleteCharAt(res.length()-1);
            }
            res.append(list.get(i));
            dfs(lists, res, out+1, i);
        }
    }


}
