package demo;

/**
 * @author liangpf
 * @Date 2019/9/29
 */
public class LC19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            if (fast == null)
                return head;
            i++;
        }
        while (fast.next != null && slow.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
