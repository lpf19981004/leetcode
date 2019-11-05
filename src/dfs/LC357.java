package dfs;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC357 {

    public static void main(String[] args) {
        LC357 demo = new LC357();
        System.out.println(demo.countNumbersWithUniqueDigits(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        long total = (long) Math.pow(10, n);
        int cnt = 0;
        for (int i = 0; i < total; i++) {
            String str = String.valueOf(i);
            boolean flag = true;
            boolean[] exist = new boolean[10];
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                int index = ch - '0';
                if (!exist[index]){
                    exist[index] = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;

        }
        return cnt;
    }
}
