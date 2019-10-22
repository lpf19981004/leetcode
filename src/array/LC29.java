package array;

/**
 * @author liangpf
 * @date 2019/10/15
 */
public class LC29 {

    public static void main(String[] args) {
        LC29 demo = new LC29();
        int divide = demo.divide(-2147483648, -1);
        int a = -2147483648;
        System.out.println(divide);
    }

    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;
        boolean flag1 = true;
        boolean flag2 = true;
        long num1 = dividend;
        long num2 = divisor;
        if(dividend<0){
            flag1 = false;
            num1 = Long.parseLong(String.valueOf(dividend).substring(1));
        }
        if(divisor<0){
            flag2 = false;
            num2 = Long.parseLong(String.valueOf(divisor).substring(1));
        }
        long cnt = 0;
        while(num1>=num2){
            num1-=num2;
            cnt++;
        }
        if(cnt>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (flag1 == flag2) ? (int)cnt:-(int)cnt;

    }
}
