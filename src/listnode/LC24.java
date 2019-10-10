package listnode;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC24 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        swapPairs(head);
    }


    public static ListNode swapPairs(ListNode head) {
        int cnt = 0;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode p = temp.next;
        ListNode pre = null;
        while (p != null) {
            cnt++;
            if (cnt >= 2 && cnt % 2 == 0) {
                ListNode next = p.next;
                pre.next = next;
                p.next = pre;
                pre = p;
                p = next;
            }else {
                pre = p;
                p = p.next;
            }
        }
        return temp.next;
    }
}
