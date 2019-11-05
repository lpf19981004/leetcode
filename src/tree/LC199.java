package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liangpf
 * @Date 2019/10/22
 */
public class LC199 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        LC199 demo = new LC199();
        List<Integer> ans = demo.rightSideView(node);
        System.out.println(ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();
            if (list.size() == level) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, level + 1));
            }
        }
        for (List<Integer> values : list) {
            Integer last = values.get(values.size() - 1);
            ans.add(last);
        }
        return ans;
    }

    List<Integer> list=new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        helper(root,0);
        return list;
    }

    public void helper(TreeNode node,int n){
        if(node==null) return;
        if(n==list.size()) list.add(node.val);
        helper(node.right,n+1);
        helper(node.left,n+1);

    }
}
