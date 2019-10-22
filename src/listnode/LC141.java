package listnode;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != null && fast.val == slow.val)
                return true;
        }
        return false;
    }
}
