import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 이 테스트코드는 <a href="https://github.com/PENEKhun/Baekjoon-java-starter">Baekjoon-java-starter </a>를 사용하여
 * 생성되었습니다.
 *
 * @Author : PENEKhun
 */
public class TestHelper {

  public static void main(String[] args) {
    TestCase[] testCases = new TestCase[] {
        new TestCase(
// input
            """
                25:09:1985:aa:091:4846:374:bb
                """,
// output
            """
                0025:0009:1985:00aa:0091:4846:0374:00bb
                """),
        new TestCase(
// input
            """
                ::1
                """,
// output
            """
                0000:0000:0000:0000:0000:0000:0000:0001
                """),

        new TestCase(
            """
                25:0919:85:aa::1
                """,
            """
                0025:0919:0085:00aa:0000:0000:0000:0001
                """
        ),

        new TestCase(
            """
                25:0919:85::1:aa:1
                """,
            """
                0025:0919:0085:0000:0000:0001:00aa:0001
                """
        ),
        new TestCase(
            """
                2001:db8:85a3:0:00:8a2e:370:7334
                """,
            """
                2001:0db8:85a3:0000:0000:8a2e:0370:7334
                """),
        new TestCase(
            """
                1:2:3:4:5:6:7::
                """,
            """
                0001:0002:0003:0004:0005:0006:0007:0000
                """
        )
        ,

    };

    int passedCases = 0;

    for (int i = 0; i < testCases.length; i++) {
      TestCase testCase = testCases[i];

      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      PrintStream printStream = new PrintStream(outputStream);
      PrintStream printOut = System.out;
      System.setOut(printStream);
      System.setIn(new ByteArrayInputStream(testCase.input.getBytes()));

      try {
        Main.main(new String[0]);
      } catch (Exception e) {
        System.setOut(printOut);
        printFail(i + 1, testCase, "Exception 발생");
        e.printStackTrace();
      }

      String output = outputStream.toString();
      System.setOut(printOut);
      if (output.equals(testCase.expectedOutput)) {
        passedCases++;
        continue;
      } else {
        printFail(i + 1, testCase,
            red("""
                [실제 값]
                %s
                """.formatted(output)));
      }
    }

    System.out.println("테스트 완료 (" + passedCases + " / " + testCases.length + ")");
    if (passedCases == testCases.length) {
      System.out.println("주어진 케이스에 대해 잘 동작하고 있습니다.");
    }
  }

  public static void printFail(int caseNumber, TestCase testCase, String message) {
    System.out.printf("""
        ====== %s ======
        [입력 값]
        %s
        [기대 값]
        %s
        """, red(caseNumber + " 번째 케이스 실패"), testCase.input, testCase.expectedOutput);

    System.out.println(message);
  }

  public static String red(String message) {
    return "\u001B[31m%s\u001B[0m".formatted(message);
  }

  public static class TestCase {

    public String input;
    public String expectedOutput;

    public TestCase(String input, String expectedOutput) {
      this.input = input;
      this.expectedOutput = expectedOutput;
    }
  }
}
