package nowcoder.wangyi2018;

import java.util.Scanner;

/**
 * @author liangpf
 * @Date 2019/10/23
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int num1 = Integer.parseInt(num);
        int num2 = Integer.parseInt(new StringBuilder(num).reverse().toString());
        System.out.println(num1+num2);
        scanner.close();
    }
}
