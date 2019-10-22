package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @date 2019/10/18
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class LC113 {
    private List<List<Integer>> ans = new ArrayList<>();
    /*
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        findSum(root, sum, new ArrayList<>());
        return ans;
    }

    private void findSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null || sum < 0) return;
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        findSum(root.left, sum, list);
        findSum(root.right, sum, list);
        list.remove(list.size() - 1);
    }
}
