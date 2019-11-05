package tree;

import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/22
 */
public class LC129 {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, new StringBuilder());
        return ans;
    }

    public void sumNumbers(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val);
        if (root.left == null && root.right == null){
            ans+=Integer.parseInt(builder.toString());
        }
        sumNumbers(root.left, builder);
        sumNumbers(root.right,builder);
        builder.deleteCharAt(builder.length()-1);
    }
}
