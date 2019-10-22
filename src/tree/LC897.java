package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC897 {

    private List<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        preOrder(root);
        TreeNode node = new TreeNode(0);
        TreeNode n = node;
        for (int i = 0; i < list.size(); i++) {
            TreeNode right = new TreeNode(list.get(i));
            n.right = right;
            n = right;
        }
        return node.right;
    }

    private void preOrder(TreeNode root) {
        if (root.left != null) preOrder(root.left);
        list.add(root.val);
        if (root.right != null) preOrder(root.right);
    }

}
