package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null) {
            String s1 = order(root1, new StringBuilder());
            String s2 = order(root2, new StringBuilder());
            return s1.equals(s2);
        }
        return false;
    }
    private String order(TreeNode root, StringBuilder builder) {
        if (root == null) return "";
        if (root.left == null && root.right == null)
            builder.append(root.val);
        order(root.left, builder);
        order(root.right, builder);
        return builder.toString();
    }

    private boolean check(String s1, String s2) {
        // s1 < s2
        int index = -1, i;
        for (i = 0; i < s1.length(); i++) {
            index = s2.indexOf(s1.charAt(i));
            if (index != -1) break;
        }
        if (index == -1) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = index; j < s2.length(); j++) {
            map.put(s2.charAt(j), j);
        }
        int pre = 0;
        for (; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            Integer value = map.get(ch);
            if (value == null || value < pre) return false;
            pre = value;
        }
        return true;
    }
}
