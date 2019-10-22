package tree;

/**
 * @author liangpf
 * @date 2019/10/17
 */
public class LC104 {


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
