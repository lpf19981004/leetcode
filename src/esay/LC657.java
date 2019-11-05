package esay;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC657 {



    public boolean judgeCircle(String moves) {
        int x = 0,y = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch){
                case 'U':
                    x+=1;
                    break;
                case 'D':
                    x-=1;
                    break;
                case 'L':
                    y-=1;
                    break;
                case 'R':
                    y+=1;
                    break;
                default:
                    throw new IllegalArgumentException("input data error");
            }
        }
        return x == 0 && y==0;
    }
}
