package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC670 {

    public static void main(String[] args) {
        int ans = new LC670().maximumSwap(98368);
        System.out.println(ans);
    }


    public int maximumSwap(int num) {
        StringBuilder ans = new StringBuilder(String.valueOf(num));
        char[] chars = ans.toString().toCharArray();
        Arrays.sort(chars);
        StringBuilder builder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        String max = builder.toString();
        for (int i = 0, j = 0; i < ans.length(); i++) {
            // 2736
            // 7632
            char c = ans.charAt(i);
            char m = max.charAt(j);
            if (c == m) {
                j++;
            } else {
                int index = ans.indexOf(String.valueOf(m),i);
                ans.setCharAt(i, m);
                ans.setCharAt(index,c);
                break;
            }
        }
        return Integer.parseInt(ans.toString());
    }
}
