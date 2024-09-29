import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  BAEKJOON 2941 크로아티아 알파벳
  https://www.acmicpc.net/problem/2941
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    for (String alphabet : croatiaAlphabets) {
      str = str.replace(alphabet, "@");
    }

    System.out.println(str.length());
  }
}
