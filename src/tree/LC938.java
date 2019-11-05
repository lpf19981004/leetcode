package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC938 {
    /*
                            10
                        5       15
                     3      7       18


                10,5,15,3,7,13,18,1,null,6

                            10
                       5        15
                   3      7   13    18
                 1  6
     */

    private int result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        help(root, L, R);
        return result;
    }

    public void help(TreeNode root, int L, int R){
        if(root == null){
            return;
        }
        if(root.val < L){
            help(root.right, L, R);
        } else if(root.val > R){
            help(root.left, L, R);
        } else {
            result += root.val;
            help(root.left, L, R);
            help(root.right, L, R);
        }

    }

}
