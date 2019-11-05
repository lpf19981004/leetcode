package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liangpf
 * @Date 2019/10/26
 */
public class MyNest3 {
    List<List<Integer>> combinationSum2(List<Integer> candidates, int target) {
        Collections.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        dp.get(0).add(Collections.singletonList(0));
        int samek = 0;
        for (int k = 0; k < candidates.size(); ++k){
            int n = candidates.get(k);
            if (k > 0 && n == candidates.get(k - 1)){
                samek ++;
            }else{
                samek = 0;
            }
            for (int i = target; i >= n; --i){
                for (int j = 0; j < dp.get(i-n).size(); ++j){
                    boolean use = true;
                    if (samek > 0){
                        if( dp.get(i-n).get(j).size() >= samek){
                            for (int l = 0; l < samek; ++l){
                                List<Integer> temp = dp.get(i - n).get(j);
                                if(n!= temp.get(temp.size()-1)- l - 1){
                                    use = false;
                                    break;
                                }
                            }
                        }else{
                            use = false;
                        }
                    }
                    if (use){
                        dp.get(i).add(dp.get(i-n).get(j));
                        List<List<Integer>> list = dp.get(i);
                        list.get(list.size()-1).add(n);
                    }
                }
            }
        }
        return dp.get(target);
    }
}
