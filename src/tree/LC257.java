package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liangpf
 * @date 2019/10/17
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *     1
 *   /   \
 *  2     3
 * / \
 * 4  5
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class LC257 {
    private List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        binaryTreePaths(root,new ArrayList<>());
        return ans;
    }
    private void binaryTreePaths(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
                if (i!=list.size()-1){
                    builder.append("->");
                }
            }
            ans.add(builder.toString());
            list.remove(list.size()-1);
            return;
        }
        if (root.left!=null)
            binaryTreePaths(root.left,list);
        if (root.right!=null)
            binaryTreePaths(root.right,list);
        list.remove(list.size()-1);
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new LinkedList<>();
        if(root == null) {return list;}
        // 遍历节点
        // 创建一个队列，只要队列不为空就一直循环下去，即只要没有遍历玩所有的节点
        // 类似二叉树的层序遍历
        Queue<Pair<TreeNode, String>> q = new LinkedList<>();
        q.offer(new Pair<>(root, root.val + ""));
        while (!q.isEmpty()) {
            // 获取队头的节点
            Pair<TreeNode, String> p = q.poll();
            TreeNode key = p.getKey();
            String value = p.getValue();
            // 判断是否到达叶子节点
            if (key.left == null && key.right == null) {
                list.add(value);
                continue;
            }
            // 如果左子树不为空，则将左节点添加进去，value为父节点的value拼上当前节点的值
            // value = 1
            // key.left.val = 2
            // newValue = 1->2
            if (key.left != null) {
                q.offer(new Pair<>(key.left, value + "->" + key.left.val));
            }
            if (key.right != null) {
                q.offer(new Pair<>(key.right, value + "->" + key.right.val));
            }
        }
        return list;
    }

}
