package listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        List<Integer> temp = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                temp.add(list.val);
                list = list.next;
            }
        }
        temp.sort(Integer::compareTo);
        for (Integer val : temp) {
            p.next = new ListNode(val);
            p = p.next;
        }

        return head.next;
    }
}
