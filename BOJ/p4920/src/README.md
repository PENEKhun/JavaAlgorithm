# 테트리스 게임

> 문제 번호 : 4920  
> 출처 : https://www.acmicpc.net/problem/4920

| 메모리 제한 | 시간 제한 |
|--------|-------|
| 128 MB | 1.0 초 |

## 문제 설명

<p>테트리스는 아래와 같은 5가지 조각으로 이루어져 있다.</p>
<p><img alt="" src="/upload/images/tet.png" style="height:56px; width:343px"></p>
<p>정수로 이루어진 N×N 표가 주어진다. 테트리스 블록 중 하나를 표에 놓아 블록 아래에 있는 숫자의 합의 최댓값을 구하는 프로그램을 작성하시오.</p>
<p>모든 테트리스 블록은 90도씩 회전시킬 수 있다. 일부 조각은 총 4가지 형태를 가질 수 있다. 블록이 모두 표 안에 들어있는 형태는 모두 가능한 형태이다.</p>
<p><img alt="" src="/upload/images/tet2(1).png" style="height:116px; width:476px"></p>
<p>예를 들어, 가장 왼쪽 블록을 첫 행에 놓으면 합 80을 얻을 수 있다. 90도 회전시켜 셋째 열에 놓으면 91을 얻을 수 있다.</p>
<p>표의 크기가 4×4인 경우에 블록을 놓는 방법의 수는 총 77가지이다. 위의 예제에서 가장 큰 합은 120이다.</p>
