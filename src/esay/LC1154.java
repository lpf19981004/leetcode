package esay;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC1154 {

    public static void main(String[] args) {
        int ans = new LC1154().dayOfYear("2003-03-01");
        System.out.println(ans);
    }


    public int dayOfYear(String date) {

        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 如果是闰年
        if (year % 4 == 0 && year % 100 != 0) {
            dayOfMonth[1] = 29;
        }
        int ans = 0;
        for (int i = 0; i < month-1; i++) {
            ans += dayOfMonth[i];
        }
        return ans+day;
    }
}
