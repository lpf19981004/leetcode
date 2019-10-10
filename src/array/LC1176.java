package array;

/**
 * @author liangpf
 * @Date 2019/10/9
 */
public class LC1176 {

    public static void main(String[] args) {
        int[] arr = new int[]{6,13,8,7,10,1,12,11};
        int res = dietPlanPerformance(arr, 6, 5, 37);
        System.out.println(res);
    }
    // [6,13,8,7,10,1,12,11]
    //6
    //5
    //37
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        for(int i=0;i<calories.length;i++){
            int temp = 0,index = i;
            for(int j=0;j<k && index<calories.length;j++){
                temp+=calories[index++];
            }
            if(temp<lower){
                sum--;
            }else if(temp>upper){
                sum++;
            }
            i+=(k-1);
        }
        return sum;
    }
}
