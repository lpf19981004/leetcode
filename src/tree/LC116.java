package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC116 {


    public Node connect(Node root) {
        if (root == null) return null;
        // 如果存在左子树
        if (root.left != null) {
            // 左子树的next为右子树
            root.left.next = root.right;
            // 如果存在右子树 将右子树的next指向root.next的左子树
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        root.next = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                node.left.next = node.right;
                if (node.right!=null){
                    node.right.next = node.next.left;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }

}
