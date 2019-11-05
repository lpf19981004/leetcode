package practice.string;

/**
 * @author liangpf
 * @Date 2019/11/1
 */
public class demo1 {

    public static void main(String[] args) {
        String ans = new demo1().addBinary("1111", "11");
        System.out.println(ans);
    }

    /*
        1111
          11
        如果两个字符串的长度不相等,把短的字符串进行补0
     */

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

}
