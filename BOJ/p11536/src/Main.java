import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> asc = new ArrayList<>();
    ArrayList<String> desc = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String name = br.readLine();
      asc.add(name);
      desc.add(name);
      names.add(name);
    }
    
    Collections.sort(asc);
    Collections.sort(desc, Collections.reverseOrder());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (names.equals(desc)) {
      bw.write("DECREASING\n");
    } else if (names.equals(asc)) {
      bw.write("INCREASING\n");
    } else {
      bw.write("NEITHER");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}