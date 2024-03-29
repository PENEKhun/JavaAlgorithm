import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #11650 좌표 정렬하기
    url : https://www.acmicpc.net/problem/11650

    문제
        2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
        둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

    출력
        첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

*/

public class Main {
    public static class Cord {
        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Cord> cords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            cords.add(
                new Cord(
                    Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        cords.sort(Comparator.comparing(Cord::getX).thenComparing(Cord::getY));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Cord cord : cords) {
            bw.write(cord.getX() + " " + cord.getY() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
