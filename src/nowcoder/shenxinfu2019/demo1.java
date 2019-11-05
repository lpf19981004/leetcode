package nowcoder.shenxinfu2019;

import java.util.Scanner;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String sub = scanner.next();
        if (s.charAt(0) != sub.charAt(0) && sub.charAt(0) != '?'
                || s.length() < sub.length()) {
            System.out.println(-1);
            return;
        }
        int len = 1;
        for (int i = 1, j = 1; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            if (ch != '?' && ch != s.charAt(j)) {
                System.out.println(-1);
                return;
            } else if (ch == '?') {
                i++;
                j++;
                if (i == sub.length()) {
                    len++;
                    break;
                } else {
                    ch = sub.charAt(i);
                    for (int k = 0; k < 3; k++) {
                        if (s.charAt(j) == ch){
                            len+=1;
                            break;
                        }else {
                            if (s.charAt(j) == '\0')
                                k--;
                            j++;
                            len++;
                        }
                    }
                }
            }
        }
        System.out.println(len);
        scanner.close();
    }
}
