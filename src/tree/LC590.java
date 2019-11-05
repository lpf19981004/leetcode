package tree;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC590 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    private List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return ans;
        ans.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child);
            }
        }
        return ans;
    }
}
