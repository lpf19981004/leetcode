package listnode;

import java.util.List;
import java.util.Stack;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC143 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4});
        new LC143().reorderList(listNode);
        ListNode.printList(listNode);
    }


    public void reorderList(ListNode head) {
        if (head == null) return;
        int len = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            len++;
            stack.push(p);
            p = p.next;
        }
        p = head;
        int cnt = len / 2;
        for (int i = 0; i < cnt; i++) {
            ListNode tail = stack.pop();
            ListNode next = p.next;
            tail.next = next;
            p.next = tail;
            p = next;
        }
        p.next = null;
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点，链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //第二个链表倒置
        newHead = reverseList(newHead);

        //链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }

    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }


}
