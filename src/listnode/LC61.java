package listnode;

import java.util.Stack;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC61 {

    public static void main(String[] args) {
        ListNode listNode = new LC61().rotateRight(ListNode.createListNode(new int[]{1, 2, 3, 4, 5}), 5);
        ListNode.printList(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode first = head;
        ListNode p = first;
        int len = 1;
        while (p.next != null) {
            len++;
            stack.push(p);
            p = p.next;
        }
        k %= len;
        for (int i = 0; i < k; i++) {
            ListNode last = stack.pop();
            ListNode next = last.next;
            last.next = null;
            next.next = first;
            first = next;
        }
        return first;
    }
}
