import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int score = s.nextInt();
      char level;
      if (score >= 90){
        level = 'A';
      } else if (score >= 80){
        level = 'B';
      } else if (score >= 70){
        level = 'C';
      } else if (score >= 60){
        level = 'D';
      } else {
        level = 'F';
      }
      System.out.println(level);
  }
}

