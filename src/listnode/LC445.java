package listnode;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class LC445 {

    public static void main(String[] args) {
        ListNode node = new LC445().addTwoNumbers(ListNode.createListNode(new int[]{9, 9, 9}),
                ListNode.createListNode(new int[]{1}));
        ListNode.printList(node);
    }

    private int len1 = 0;
    private int len2 = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        l1 = reverse(l1, true);
        l2 = reverse(l2, false);
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (len1 > len2) {
            while (p2 != null) {
                int sum = p1.val + p2.val;
                if (sum >= 10) {
                    add(p1, sum);
                } else {
                    p1.val = sum;
                }
                p2 = p2.next;
                p1 = p1.next;
            }
            return reverse(l1, false);
        } else {
            while (p1 != null) {
                int sum = p1.val + p2.val;
                if (sum >= 10) {
                    add(p2, sum);
                } else {
                    p2.val = sum;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return reverse(l2, false);
        }
    }
    private void add(ListNode node, int sum) {
        ListNode next;
        node.val = sum - 10;
        next = node.next;
        if (next == null) {
            node.next = new ListNode(1);
            return;
        }
        while (next.next != null && next.val + 1 >= 10) {
            next.val = 0;
            next = next.next;
        }
        if (next.val + 1 < 10) {
            next.val++;
        } else {
            next.val = 0;
            next.next = new ListNode(1);
        }
    }

    private ListNode reverse(ListNode node, boolean b) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            if (b) len1++; else len2++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
