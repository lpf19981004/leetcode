package listnode;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode createListNode(int[] arr) {
        ListNode temp = new ListNode(0);
        ListNode p = temp;
        for (int i : arr) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return temp.next;
    }

    public static void printList(ListNode head){
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        ListNode p = head;
        while (p.next!=null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val + "->NULL");
    }
}
