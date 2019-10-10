package string;

/**
 * @author liangpf
 * @date 2019/10/10
 */
public class LC866 {

    public static void main(String[] args) {
        LC866 demo = new LC866();
        int res = demo.primePalindrome(9989900);
        System.out.println(res);
    }

    public int primePalindrome(int N) {
        StringBuilder builder = new StringBuilder();
        int temp = N;
        while(true){
            if(!isp(temp)){
                temp++;
                continue;
            }
            builder.append(temp);
            String s1 = builder.toString();
            String s2 = builder.reverse().toString();
            if(s1.equals(s2) && temp>=N){
                break;
            }
            builder.setLength(0);
            temp++;
        }
        return temp;
    }

    private boolean isp(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
