package tree;

/**
 * @author liangpf
 * @date 2019/10/18
 */
public class LC599 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int res = 1;
        if (root.children!=null){
            for (Node child : root.children) {
                res = Math.max(maxDepth(child),res);
            }
        }
        return res;
    }
}
