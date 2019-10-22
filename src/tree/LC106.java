package tree;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderLen = inorder.length;
        int postorderLen = postorder.length;
        if (inorderLen != postorderLen) return null;
        return buildTree(inorder, 0, inorderLen, postorder, 0, postorderLen);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inLeft >= inRight || postLeft >= postRight) return null;
        // 取出后续遍历的第一个节点作为
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历中找到和根节点相同值的位置
        // 这个位置的左边就是根节点的左子树
        // 这个位置的右边就是根节点的右子树
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                // 中序遍历 inorder = [9,3,15,20,7]
                // 后序遍历 postorder = [9,15,7,20,3]
                int leftLen = i - inLeft; // 左子树的节点个数
                root.left = buildTree(inorder, inLeft, i, postorder, postLeft, postLeft+leftLen);
                root.right = buildTree(inorder, i + 1, inRight, postorder, postLeft + leftLen, postRight - 1);
            }
        }
        return null;
    }


}
