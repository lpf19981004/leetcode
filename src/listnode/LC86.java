package listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC86 {

    public static void main(String[] args) {
        ListNode node = new LC86().partition(ListNode.createListNode(new int[]{1, 4, 3, 2, 5, 2}), 3);
        ListNode.printList(node);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode p = head;
        ListNode temp = new ListNode(0);
        ListNode newHead = temp;
        List<ListNode> list = new ArrayList<>();
        while (p!=null){
            if (p.val<x){
                newHead.next = p;
                newHead = newHead.next;
            }else {
                list.add(new ListNode(p.val));
            }
            p = p.next;
        }
        for (ListNode node : list) {
            newHead.next = node;
            newHead = newHead.next;
        }
        return temp.next;
    }
}
