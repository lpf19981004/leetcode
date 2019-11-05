package esay;

import java.util.Stack;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC1021 {

    public static void main(String[] args) {
        String s = new LC1021().removeOuterParentheses("()()");
        System.out.println(s);
    }

    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            switch (ch){
                case '(':
                    if (stack.peek() == '('){
                        ans.append(ch);
                        stack.push(ch);
                    }else {
                        throw new RuntimeException("input error");
                    }
                    break;
                case ')':
                    if (stack.peek() == '(' && stack.size() == 1){
                        stack.pop();
                    }else {
                        ans.append(ch);
                        stack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        return ans.toString();
    }
}
