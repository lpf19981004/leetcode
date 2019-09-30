package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangpf
 * @Date 2019/9/25
 */
public class LC697 {

    public static void main(String[] args) {
        LC697 demo = new LC697();
        int[] nums = new int[]{2,1};
        int shortestSubArray = demo.findShortestSubArray(nums);
        System.out.println(shortestSubArray);
    }

    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int i=0;i<nums.length;i++){
            Integer cnt = map.get(nums[i]);
            if(cnt != null){
                cnt++;
                map.put(nums[i],cnt);
                max = Math.max(max, cnt);
            }else{
                map.put(nums[i],1);
            }
        }
        int minLength = nums.length;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().equals(max)){
                minLength = Math.min(minLength,SearchIndex(nums,entry.getKey()));
            }
        }
        return minLength;
    }
    private int SearchIndex(int[] nums,int val){
        int start = -1;
        int end = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                if(start == -1){
                    start = i;
                    end = i;
                }else if(i>start){
                    end = i;
                }
            }
        }
        return (end-start) +1 ;
    }
}
