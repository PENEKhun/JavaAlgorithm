import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import javax.sql.rowset.BaseRowSet;

/*
    BAEKJOON #1620 나는야 포켓몬 마스터 이다솜
    https://www.acmicpc.net/problem/1620
*/

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    HashMap<Integer, String> numToPoke = new HashMap<>();
    HashMap<String, Integer> pokeToNum = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      String pokemonName = br.readLine();
      numToPoke.put(i, pokemonName);
      pokeToNum.put(pokemonName, i);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < M; i++) {
      String command = br.readLine();
      if (command.matches("\\d*")) {
        int num = Integer.parseInt(command);
        bw.write(numToPoke.get(num) + "\n");
      } else {
        // find name
        bw.write(pokeToNum.get(command) + "\n");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
