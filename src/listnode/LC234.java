package listnode;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode p = head;
        ListNode node = reverseList(head);
        while (p!=null){
            if (p.val!=node.val)
                return false;
            p = p.next;
            node = node.next;
        }
        return true;
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
