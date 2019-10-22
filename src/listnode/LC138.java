package listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangpf
 * @date 2019/10/21
 */
public class LC138 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node node = head;
        while (node != null){
            lookup.put(node, new Node(node.val, null, null));
            node = node.next;
        }
        node = head;
        while (node != null){
            lookup.get(node).next = lookup.get(node.next);
            lookup.get(node).random = lookup.get(node.random);
            node = node.next;
        }
        return lookup.get(head);
    }
}
