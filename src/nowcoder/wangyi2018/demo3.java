package nowcoder.wangyi2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class demo3 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            Integer oldCnt = map.get(ch);
            int cnt = 1;
            while (++i < length && str.charAt(i) == ch)
                cnt++;
            if (cnt>1) i--;
            if (oldCnt == null) {
                map.put(ch, cnt);
            } else {
                oldCnt = Math.min(cnt, oldCnt);
                map.put(ch, oldCnt);
            }
        }
        int size = map.size();
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            sum += value;
        }
        int ans = sum / size;
        double temp = (double) sum / size;
        if ((temp - ans + 0.5) > 1) {
            ans += 1;
        }
        System.out.printf("%.2f", temp);

        scanner.close();
    }
}
