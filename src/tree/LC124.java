package tree;

/**
 * @author liangpf
 * @Date 2019/10/22
 */
public class LC124 {

    public int maxPathSum(TreeNode root) {

        return maxPathSum(root,root.val);
    }

    private int maxPathSum(TreeNode root, int val) {
        if (root == null) return 0;
        val += root.val;
        int childMax = Math.max(maxPathSum(root.left,val), maxPathSum(root.right,val));
        val = Math.max(val+childMax, childMax);
        return 0;
    }
}
