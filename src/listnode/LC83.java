package listnode;

/**
 * @author liangpf
 * @Date 2019/9/30
 * 83. 删除排序链表中的重复元素
 */
public class LC83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p!=null && p.next!=null){
            if (p.val == p.next.val)
                p.next = p.next.next;
            else {
                p = p.next;
            }
        }
        return head;
    }
}
