import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #1107 리모컨
    url : https://www.acmicpc.net/problem/1107
*/

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int channel = Integer.parseInt(br.readLine());
    int buttonBrokenCount = Integer.parseInt(br.readLine());
    int[] splitBroken;
    boolean[] buttonBrokenState = new boolean[10];
    if (buttonBrokenCount != 0) {
      splitBroken = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int i : splitBroken) {
        buttonBrokenState[i] = true;
      }
    }

    int[] goodButtons = new int[10 - buttonBrokenCount];

    int idx = 0;
    for (int i = 0; i < 10; i++) {
      if (!buttonBrokenState[i]) {
        goodButtons[idx++] = i;
      }
    }

    int nowChannel = 100;

    // 이동할 가장 가까운 채널 찾기
    String[] channelArr = String.valueOf(channel).split("");
    StringBuilder number = new StringBuilder();
    /*
    모든 숫자들의 콤비네이션을 만들고 nowChannel에 near한 값을 찾자?
     */

    boolean isError = false;
    StringBuilder target = new StringBuilder();
    for (int i = 0; i < channelArr.length; i++) {
      Integer min = null;
      Integer num = null;
      target.append(channelArr[i]);

      int targetNum = Integer.parseInt(target.toString());
      for (int goodButton : goodButtons) {
        int now = Integer.parseInt(number + "0");

        now += goodButton;
        int diff = Math.abs(targetNum - now);
        if (min != null) {
          if (diff < min) {
            min = diff;
            num = goodButton;
          }
        } else {
          min = diff;
          num = goodButton;
        }
      }

      if (min == null) {
        isError = true;
        break;
      } else {
        number.append(num);
      }
    }

    int justUpDown = Math.abs(channel - nowChannel);
    String result = "";
    if (isError) {
      // 그냥 위 아래로만 하는 경우
      result = String.valueOf(justUpDown);
    } else {
      int withButton = channelArr.length;
      withButton = withButton + Math.abs(channel - Integer.parseInt(number.toString()));

      result = String.valueOf(Math.min(justUpDown, withButton));
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(result + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
