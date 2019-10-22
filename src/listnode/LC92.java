package listnode;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC92 {

    public static void main(String[] args) {
        ListNode node = new LC92().reverseBetween(ListNode.createListNode(new int[]{1, 2, 3, 4, 5}), 3, 4);
        ListNode.printList(node);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        ListNode start = head;
        for (int i = 0;i<m-1;i++){
            start = start.next;
            pre = pre.next;
        }
        ListNode end = start;
        for (int i = 0;i<(n-m);i++)
            end = end.next;
        ListNode next = end.next;
        end.next = null;
        pre.next = reverseListNode(start);
        start.next = next;
        return temp.next;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p!=null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
