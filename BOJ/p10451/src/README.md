# 순열 사이클

> 문제 번호 : 10451  
> 출처 : https://www.acmicpc.net/problem/10451

| 메모리 제한 | 시간 제한 |
|--------|-------|
| 256 MB | 1.0 초 |

## 문제 설명

<p><img alt="" src="/upload/images2/permut.png" style="float:right; height:134px; width:264px"></p>
<p>1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러 가지가 있다. 예를 들어, 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면 \(\begin{pmatrix} 1 &amp; 2 &amp;3&amp;4&amp;5&amp;6&amp;7&amp;8 \\ &nbsp;3&amp; 2&amp;7&amp;8&amp;1&amp;4&amp;5&amp;6 \end{pmatrix}\) 와 같다. 또는, Figure 1과 같이 방향 그래프로 나타낼 수도 있다.</p>
<p>순열을 배열을 이용해 \(\begin{pmatrix} 1 &amp; \dots &amp; i &amp; \dots &amp;n \\ &nbsp;\pi_1&amp; \dots&amp; \pi_i &amp; \dots &amp; \pi_n \end{pmatrix}\) 로 나타냈다면, i에서 π<sub>i</sub>로 간선을 이어 그래프로 만들 수 있다.</p>
<p>Figure 1에 나와있는 것 처럼, 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6) 에는 총 3개의 사이클이 있다. 이러한 사이클을 "순열 사이클" 이라고 한다.</p>
<p>N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.</p>

