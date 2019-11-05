package string;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC557 {

    public static void main(String[] args) {
        String s = new LC557().reverseWords("Let's take LeetCode contest");
        System.out.println(s.equals("s'teL ekat edoCteeL tsetnoc"));
    }


    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] split = s.split("\\s");
        for (String str : split) {
            ans.append(reverse(str)).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    private char[] reverse(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }
}
