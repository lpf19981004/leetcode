package stack;

import java.util.Stack;

/**
 * @author liangpf
 * @Date 2019/9/20
 * 最小栈结构
 */
public class LC155 {


    /**
     * initialize your data structure here.
     */
    public LC155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    // 思路 1：数据栈和辅助栈在任何时候都同步

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

}
