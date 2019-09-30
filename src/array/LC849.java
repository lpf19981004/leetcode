package array;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC849 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,1};
        int i = maxDistToClosest(nums);
        System.out.println(i);
    }


    public static int maxDistToClosest(int[] seats) {
        if (seats.length == 1) return 0;
        int start = 0;
        int len = 0;
        if (seats[start] == 0) {
            len++;
            while (start < seats.length && seats[start + 1] == 0) {
                start++;
                len++;
            }
        }
        int end = seats.length - 1;
        int len2 = 0;
        if (seats[end] == 0) {
            len2++;
            while (end >= 0 && seats[end-1] == 0) {
                end--;
                len2++;
            }
        }
        len = Math.max(len, len2);
        int cnt = 0;
        for (int i = start; i < end; i++) {
            if (seats[i] == 0) {
                if (i!=end-1)
                    cnt++;
                else {
                    int temp = cnt%2 == 0 ? cnt/2 : cnt/2+1;
                    len = Math.max(len, temp);
                }
            } else {
                if(cnt>0){
                    int temp = cnt%2 == 0 ? cnt/2 : cnt/2+1;
                    len = Math.max(len, temp);
                }
                cnt = 0;
            }
        }
        return len;
    }
}
