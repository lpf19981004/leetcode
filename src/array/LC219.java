package array;

import java.util.HashMap;

/**
 * @author liangpf
 * @Date 2019/9/24
 */
public class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                Integer j = map.get(nums[i]);
                if (Math.abs(i-j)<=k)
                    return true;
                else
                    map.put(nums[i],i);
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
