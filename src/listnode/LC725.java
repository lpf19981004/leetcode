package listnode;

/**
 * @author liangpf
 * @Date 2019/10/23
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * 示例 1：
 * <p>
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 */
public class LC725 {

    public static void main(String[] args) {
        ListNode[] nodes = new LC725()
                .splitListToParts(ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11}), 3);
        for (ListNode node : nodes) {
            ListNode.printList(node);
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode cur = root;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        ListNode[] res = new ListNode[k];
        int[] length = new int[k];
        int avg = size / k, remain = size % k;
        for (int i = 0; i < length.length; i++) {
            length[i] = avg;
            //将余数部分加到靠前的结点上
            if (remain-- > 0)
                length[i]++;
        }
        ListNode temp;
        cur = root;
        for (int i = 0; i < length.length; i++) {
            if (length[i] == 0)
                break;
            int count = 0;
            ListNode subHead = cur;
            while (++count < length[i]) {
                cur = cur.next;
            }
            temp = cur.next;
            cur.next = null;
            res[i] = subHead;
            cur = temp;
        }
        return res;
    }

}
