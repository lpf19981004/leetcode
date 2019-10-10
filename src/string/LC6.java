package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/9/30
 * Z字型变换
 */
public class LC6 {


    public static void main(String[] args) {
        String res = convert("LEETCODEISHIRING", 3);
        System.out.println(res);
        System.out.println(res.equals("LCIRETOESIIGEDHN"));
    }


    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

}
