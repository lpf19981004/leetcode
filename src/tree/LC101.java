package tree;

/**
 * @author liangpf
 * @date 2019/10/17
 */
public class LC101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            if (left.val != right.val) return false;
            return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        } else {
            return false;
        }
    }
}
