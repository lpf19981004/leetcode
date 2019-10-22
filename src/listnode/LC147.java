package listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC147 {

    public static void main(String[] args) {
        ListNode listNode = new LC147().insertionSortList2(ListNode.createListNode(new int[]{-1,5,3,4,0}));
        ListNode.printList(listNode);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list.sort(Integer::compareTo);
        p = head;
        int index = 0;
        while (p != null) {
            p.val = list.get(index++);
            p = p.next;
        }
        return head;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = new ListNode(head.val);
        ListNode p = head.next;
        while (p != null) {
            ListNode cur = p;
            ListNode next = p.next;
            cur.next = null;
            if (cur.val > newNode.val) {
                cur.next = newNode;
                newNode = cur;
            } else {
                ListNode tmp = newNode;
                while (tmp.next != null && cur.val < tmp.next.val) {
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
                tmp.next = cur;
            }
            p = next;
        }
        return reverseList(newNode);
    }
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
