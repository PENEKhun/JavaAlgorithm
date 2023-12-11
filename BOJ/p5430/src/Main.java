import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #5430 AC
    url : https://www.acmicpc.net/problem/5430
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < testCase; i++) {
      String command = br.readLine();
      // R = 배열의 순서를 뒤집음
      // D = 첫번째 수를 버리는 함수
      int n = Integer.parseInt(br.readLine());
      String arrInput = br.readLine().replace("[", "").replace("]", "");
      int[] arr = (arrInput.isEmpty()) ? new int[]{} :
          Arrays.stream(arrInput.split(",")).mapToInt(Integer::parseInt).toArray();

      boolean isError = false;
      boolean flip = false;

      int startIdx = 0;
      int endIdx = arr.length;

      for (char c : command.toCharArray()) {
        if (c == 'R') {
          flip = !flip;
        } else if (c == 'D') {
          if (arr.length < 1) {
            isError = true;
            break;
          }
          if (flip) {
            endIdx--;
          } else {
            startIdx++;
          }

          if (endIdx < startIdx) {
            isError = true;
            break;
          }
        } else {
          isError = true;
          break;
        }
      }

      if (isError) {
        bw.write("error\n");
      } else {
        arr = Arrays.copyOfRange(arr, startIdx, endIdx);
        if (flip) {
          int[] newArr = new int[arr.length];
          for (int index = 0; index < arr.length; index++) {
            newArr[index] = arr[arr.length - index - 1];
          }
          arr = newArr;
        }
        bw.write(Arrays.toString(arr).replace(" ", "") + "\n");
      }
    }
    bw.flush();
    bw.close();
    br.close();

  }
}
