package esay;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC461 {


    public static void main(String[] args) {
        int i = new LC461().hammingDistance(1, 4);
        System.out.println(i);
    }

    public int hammingDistance(int x, int y) {
        // 将十进制转换为二进制
        String s1 = transfer(x);
        String s2 = transfer(y);
        StringBuilder builder = new StringBuilder();
        int len1 = s1.length();
        int len2 = s2.length();
        int maxLen = 0;
        if (len1 < len2) {
            maxLen = len2;
            int diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                builder.append("0");
            }
            builder.append(s1);
            s1 = builder.toString();
        }else {
            maxLen = len1;
            int diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                builder.append("0");
            }
            builder.append(s2);
            s2 = builder.toString();
        }
        int ans = 0;
        for (int i = 0; i < maxLen; i++) {
            if (s1.charAt(i)!=s2.charAt(i))
                ans++;
        }
        return ans;
    }

    private String transfer(int x) {
        // 0 1 0 0
        StringBuilder res = new StringBuilder();
        while (x > 0) {
            int mod = x % 2;
            res.append(mod);
            x /= 2;
        }
        return res.reverse().toString();
    }
}
