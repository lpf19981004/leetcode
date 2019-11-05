package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC93 {

    public static void main(String[] args) {
        String str = "103574606193";
        List<String> strings = new LC93().restoreIpAddresses(str);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0 || s.length() < 4 || s.length()>12) return ans;
        dfs(s, 0);
        return ans;
    }

    private List<String> result = new ArrayList<>();

    private void dfs(String s, int k) {
        if (k == s.length() && result.size() == 4) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                String val = result.get(i);
                temp.append(val);
                if (i != result.size() - 1)
                    temp.append(".");
            }
            ans.add(temp.toString());
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = k; i < s.length(); i++) {
            builder.append(s.charAt(i) - '0');
            String e = builder.toString();
            int length = e.length();
            int min = (int) Math.pow(10, length - 1);
            long value = Long.parseLong(e);
            if (length!=1 && value < min)
                continue;
            if (value >= 0 && value <= 255) {
                result.add(e);
//                System.out.println("k = " + k + " list = " + result);
                dfs(s, i + 1);
                result.remove(result.size() - 1);
            } else {
                break;
            }
        }

    }


    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (i < n && j < n && k < n) {
                        String tmp1 = s.substring(0, i + 1);
                        String tmp2 = s.substring(i + 1, j + 1);
                        String tmp3 = s.substring(j + 1, k + 1);
                        String tmp4 = s.substring(k + 1);
                        if (helper(tmp1) && helper(tmp2) && helper(tmp3) && helper(tmp4))
                            res.add(tmp1 + "." + tmp2 + "." + tmp3 + "." + tmp4);
                    }
                }
            }
        }
        return res;
    }

    private boolean helper(String tmp) {
        if (tmp == null || tmp.length() == 0 || tmp.length() > 3 || (tmp.charAt(0) == '0' && tmp.length() > 1) || Integer.parseInt(tmp) > 255)
            return false;
        return true;
    }


    public List<String> restoreIpAddresses3(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        backtrack(0, "", 4, s, res, n);
        return res;
    }

    private void backtrack(int i, String tmp, int flag, String s, List<String> res, int n) {
        if (i == n && flag == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        if (flag < 0) return;
        for (int j = i; j < i + 3; j++) {
            if (j < n) {
                if (i == j && s.charAt(j) == '0') {
                    backtrack(j + 1, tmp + s.charAt(j) + ".", flag - 1, s, res, n);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255)
                    backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", flag - 1, s, res, n);
            }
        }
    }


}
