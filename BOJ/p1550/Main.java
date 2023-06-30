import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 16진수 수
        Scanner s = new Scanner(System.in).useRadix(16);
        int a = s.nextInt();
        System.out.print(a);
    }
}
