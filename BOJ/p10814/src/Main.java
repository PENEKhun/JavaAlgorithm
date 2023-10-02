import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    성훈ㅇㅏ.... 화이팅하자 ....
    solved BAEKJOON #10814 나이순 정렬
    url : https://www.acmicpc.net/problem/10814
*/

public class Main {

    public static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString(){
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            list.add(new Member(age, name));
        }

        list.sort(Comparator.comparing(Member::getAge));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Member member : list) {
            bw.write(member.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
