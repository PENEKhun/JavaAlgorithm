import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
  BAEKJOON 2252 줄 세우기
  https://www.acmicpc.net/problem/2252
*/

public class Main {

  static class Student {
    int number = 0;
    int indegree = 0;
    List<Student> next = new ArrayList<>();

    public Student(int number) {
      this.number = number;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();

    String[] NM = br.readLine().split(" ");
    int n = Integer.parseInt(NM[0]);
    int m = Integer.parseInt(NM[1]);

    Student[] students = new Student[n + 1];
    for (int i = 1; i <= n; i++) {
      students[i] = new Student(i);
    }

    // A B -> A가 B학생보다 앞에서야함.
    for (int i = 0; i < m; i++) {
      String[] input = br.readLine().split(" ");
      int frontStudentNum = Integer.parseInt(input[0]);
      int backStudentNum = Integer.parseInt(input[1]);

      students[backStudentNum].indegree++;
      students[frontStudentNum].next.add(students[backStudentNum]);
    }

    Queue<Student> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (students[i].indegree == 0) {
        q.add(students[i]);
      }
    }

    while (!q.isEmpty()) {
      Student student = q.poll();
      result.append(student.number).append(" ");

      for (Student next : student.next) {
        next.indegree--;
        if (next.indegree == 0) {
          q.add(next);
        }
      }
    }

    System.out.println(result);
  }
}
