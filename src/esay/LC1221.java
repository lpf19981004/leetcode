package esay;

import java.util.Stack;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC1221 {


    public int balancedStringSplit(String s) {

        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            switch (ch){
                case 'R':
                    if (stack.peek() == 'L'){
                        stack.pop();
                        if (stack.isEmpty())
                            ans++;
                    }else {
                        stack.push(ch);
                    }
                    break;
                case 'L':
                    if (stack.peek() == 'R'){
                        stack.pop();
                        if (stack.isEmpty())
                            ans++;
                    }else {
                        stack.push(ch);
                    }
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new LC1221().balancedStringSplit("RLLLLRRRLR");
        System.out.println(ans);
    }
}
