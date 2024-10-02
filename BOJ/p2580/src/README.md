# 스도쿠

> 문제 번호 : 2580  
> 출처 : https://www.acmicpc.net/problem/2580

| 메모리 제한 | 시간 제한 |
|--------|-------|
| 256 MB | 1.0 초 |

## 문제 설명

<p>스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.</p>
<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/508363ac-0289-4a92-a639-427b10d66633/-/preview/" style="width: 240px; height: 230px;"></p>
<p>나머지 빈 칸을 채우는 방식은 다음과 같다.</p>
<ol>
 <li>각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.</li>
 <li>굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.</li>
</ol>
<p>위의 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다.</p>
<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/38e505c6-0452-4a56-b01c-760c85c6909b/-/preview/" style="width: 239px; height: 32px;"></p>
<p>또한 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다.</p>
<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/89873d9d-56ae-44f7-adb2-bd5d7e243016/-/preview/" style="width: 86px; height: 82px;"></p>
<p>이와 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다.</p>
<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/fe68d938-770d-46ea-af71-a81076bc3963/-/preview/" style="width: 240px; height: 230px;"></p>
<p>게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.</p>
