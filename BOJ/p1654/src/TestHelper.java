import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 이 테스트코드는 <a href="https://github.com/PENEKhun/Baekjoon-java-starter">Baekjoon-java-starter </a>를
 * 사용하여 생성되었습니다.
 *
 * @Author : PENEKhun
 */
public class TestHelper {

  public static class TestCase {

    public String input;
    public String expectedOutput;

    public TestCase(String input, String expectedOutput) {
      this.input = input;
      this.expectedOutput = expectedOutput;
    }
  }

  public static void main(String[] args) {

    TestCase[] testCases = new TestCase[]{
        new TestCase(
// input
            """
                4 11
                802
                743
                457
                539
                """,
// output
            """
                200
                """),

        new TestCase(
            """
                1 1
                50
                """,
            """
                50
                """
        ),

        new TestCase(
            """
                3 4
                2
                6
                19
                """,
            """
                6
                """
        ),

        new TestCase(
            """
                4 4
                200
                200
                200
                200
                """,
            """
                200
                """
        )
    };

    for (TestCase testCase : testCases) {
      System.out.println("========================================");
      System.out.println("입력 값: " + testCase.input);
      System.out.println("기대 값: " + testCase.expectedOutput);

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      PrintStream printStream = new PrintStream(outputStream);
      PrintStream printOut = System.out;
      System.setOut(printStream);
      System.setIn(new ByteArrayInputStream(testCase.input.getBytes()));

      try {
        Main.main(new String[0]);
      } catch (Exception e) {
        System.out.println("NG");
        System.out.println("실행 중 에러가 발생했습니다.");
        System.out.println(e.getMessage());
        continue;
      }

      String output = outputStream.toString();
      System.setOut(printOut);
      if (output.equals(testCase.expectedOutput)) {
        System.out.println("OK");
      } else {
        System.out.println("NG");
        System.out.println("실제 값 : " + output);
      }

      System.setIn(System.in);
      System.out.println("========================================");
    }
  }
}

