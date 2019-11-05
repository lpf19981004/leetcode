package tree;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC226 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode nodeLeft = root.left;
        root.left = root.right;
        root.right = nodeLeft;

        return root;
    }
}
