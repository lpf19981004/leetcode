package dp;

/**
 * @author liangpf
 * @Date 2019/10/28
 */
public class LC392 {


    public static void main(String[] args) {

        LC392 demo = new LC392();
        System.out.println(demo.isSubsequence("a", "c"));
        String trim = demo.trim("　 一、山东天鹅棉业机械股份有限公司");
        System.out.println(trim.length());
        System.out.println(trim);

    }

    private String trim(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();
        int start = 0,end = str.length()-1;
        while (start<end && (chars[start] == '　' || chars[start] == ' ')) start++;
        while (end>start && (chars[end] == '　' || chars[end] == ' ')) end--;
        return str.substring(start, end+1);
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) return false;
        int start = -1;
        int test = 0;
        if (s.length() == 0) return true;
        char[] sc = s.toCharArray();
        for (char c : sc) {//如果遍历t的话，因为多次调用s.charAt()方法耗费很多时间
            start = t.indexOf(c, start + 1);
            if (start == -1) return false;
        }
        return true;
    }
}
