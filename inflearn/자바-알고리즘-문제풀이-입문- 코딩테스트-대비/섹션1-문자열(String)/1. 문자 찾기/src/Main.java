import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    String str = s.next().toLowerCase();
    String toFind = s.next().toLowerCase();

    int cnt = 0;

    for (char c : str.toCharArray()) {
      if (c == toFind.charAt(0)){
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}