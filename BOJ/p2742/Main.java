import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        while(i > 0){
            System.out.println(i--);
        }
    }
}
