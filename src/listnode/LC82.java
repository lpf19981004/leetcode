package listnode;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC82 {

    public static void main(String[] args) {
        ListNode node = new LC82().deleteDuplicates(ListNode.createListNode(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5}));
        ListNode.printList(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode p = temp;
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            ListNode next = cur.next;
            if (next == null) break;
            boolean flag = false;
            while (next != null && next.val == val) {
                next = next.next;
                flag = true;
            }
            if (flag) p.next = next;
            else p = cur;
            cur = next;
        }
        return temp.next;
    }
}
